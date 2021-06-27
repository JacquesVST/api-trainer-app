package tk.jvst.api.activity.dto;

import lombok.Data;
import tk.jvst.api.activity.Activity;
import tk.jvst.api.exercise.Exercise;
import tk.jvst.api.training.Training;

@Data
public class ActivityRequestDTO {

    private Long id;
    private Integer duration;
    private Integer repeats;
    private Integer sets;
    private String comments;
    private Integer sequentialOrder;
    private Long exerciseId;
    private Long trainingId;

    public Activity toModel() {
        return Activity.builder()
                .id(id)
                .duration(duration)
                .repeats(repeats)
                .sets(sets)
                .comments(comments)
                .sequentialOrder(sequentialOrder)
                .exercise(Exercise.builder().id(exerciseId).build())
                .training(Training.builder().id(trainingId).build())
                .build();
    }
}
