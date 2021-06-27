package tk.jvst.api.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.exercise.Exercise;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.training.Training;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "activity")
public class Activity extends BaseEntity {

    private Integer duration;
    private Integer repeats;
    private Integer sets;
    private String comments;
    private Integer sequentialOrder;
    @ManyToOne(targetEntity = Exercise.class)
    @JoinColumn(name = "exercise")
    private Exercise exercise;
    @ManyToOne(targetEntity = Training.class)
    @JoinColumn(name = "training")
    private Training training;
}
