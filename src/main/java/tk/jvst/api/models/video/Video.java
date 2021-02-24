package tk.jvst.api.models.video;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String base64;
    private String url;
    private byte[] thumbnail;

}
