package tk.jvst.api.video;

import lombok.Data;
import tk.jvst.api.generic.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "video")
public class Video extends BaseEntity {

    private String base64;
    private String url;
    private byte[] thumbnail;

}
