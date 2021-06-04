package tk.jvst.api.image;

import lombok.Data;
import tk.jvst.api.generic.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    private String base64;
    private String url;
    private byte[] thumbnail;

}
