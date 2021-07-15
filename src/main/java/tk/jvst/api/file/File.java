package tk.jvst.api.file;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import tk.jvst.api.generic.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Timestamp;

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
    @Column(name = "original_name")
    private String originalName;
    private String type;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;

}