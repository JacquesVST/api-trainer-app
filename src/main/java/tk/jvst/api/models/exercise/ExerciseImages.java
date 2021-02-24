package tk.jvst.api.models.exercise;

import lombok.Data;
import tk.jvst.api.models.image.Image;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exercise_images")
public class ExerciseImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = Exercise.class)
    @JoinColumn(name = "exercise")
    private Exercise exercise;
    @ManyToOne(targetEntity = Image.class)
    @JoinColumn(name = "image")
    private Image image;
    private Integer order;

}
