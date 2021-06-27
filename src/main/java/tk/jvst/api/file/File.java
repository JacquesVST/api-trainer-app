package tk.jvst.api.file;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.util.FileUtilities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "file")
public class File extends BaseEntity {

    private String url;
    private Long size;
    private String uuid;

    @Column(name = "upload_date")
    private Timestamp uploadDate;
    private String name;
    private String originalName;
    private String type;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;

    public static File fromMultipartFile(MultipartFile mpFile) {

        byte[] data = null;

        try {
            data = mpFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder()
                .size(mpFile.getSize())
                .uploadDate(Timestamp.from(Instant.now()))
                .name(FileUtilities.generateFileName())
                .originalName(mpFile.getOriginalFilename())
                .type(FileUtilities.getExtensionFromFilename(mpFile.getOriginalFilename()))
                .data(data)
                .build();
    }
}