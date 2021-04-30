package tk.jvst.api.models.training;

import lombok.Data;
import tk.jvst.api.models.image.Image;
import tk.jvst.api.models.tag.Tag;
import tk.jvst.api.models.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
