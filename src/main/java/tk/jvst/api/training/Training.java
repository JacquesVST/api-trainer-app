package tk.jvst.api.training;

import lombok.Data;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.image.Image;
import tk.jvst.api.tag.Tag;
import tk.jvst.api.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "training")
public class Training extends BaseEntity {

    private String title;
    private String description;
    private Double price;
    private Integer duration;
    private Timestamp published;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "creator")
    private User creator;
    @ManyToOne(targetEntity = Image.class)
    @JoinColumn(name = "cover")
    private Image cover;
    @ManyToMany(targetEntity = Tag.class)
    private List<Tag> tags;
}
