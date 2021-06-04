package tk.jvst.api.exercise;

import lombok.Data;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.image.Image;
import tk.jvst.api.tag.Tag;
import tk.jvst.api.user.User;
import tk.jvst.api.video.Video;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "exercise")
public class Exercise extends BaseEntity {

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
