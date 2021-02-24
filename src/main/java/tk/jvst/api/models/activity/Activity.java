package tk.jvst.api.models.activity;

import lombok.Data;
import tk.jvst.api.models.exercise.Exercise;
import tk.jvst.api.models.training.Training;

import javax.persistence.*;

@Data
@Entity
@Table(name = "activity")
public class Activity {

    @Id
    private Long id;
    private Integer duration;
    private Integer repeats;
    private Integer sets;
    private String comments;
    private Integer order;
    @ManyToOne(targetEntity = Exercise.class)
    @JoinColumn(name = "exercise")
    private Exercise exercise;
    @ManyToOne(targetEntity = Training.class)
    @JoinColumn(name = "training")
    private Training training;

}
