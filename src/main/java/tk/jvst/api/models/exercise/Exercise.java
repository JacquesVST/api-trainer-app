package tk.jvst.api.models.exercise;

import lombok.Data;
import tk.jvst.api.models.image.Image;
import tk.jvst.api.models.tag.Tag;
import tk.jvst.api.models.user.User;
import tk.jvst.api.models.video.Video;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String material;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "creator")
    private User creator;
    @ManyToOne(targetEntity = Video.class)
    @JoinColumn(name = "video")
    private Video video;
    @ManyToMany(targetEntity = Image.class)
    private List<Image> images;
    @ManyToMany(targetEntity = Tag.class)
    private List<Tag> tags;
}
