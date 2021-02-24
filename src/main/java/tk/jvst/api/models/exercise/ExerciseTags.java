package tk.jvst.api.models.exercise;

import lombok.Data;
import tk.jvst.api.models.tag.Tag;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exercise_tags")
public class ExerciseTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = Exercise.class)
    @JoinColumn(name = "exercise")
    private Exercise exercise;
    @ManyToOne(targetEntity = Tag.class)
    @JoinColumn(name = "tag")
    private Tag tag;
}
