package tk.jvst.api.exercise.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseCreateDTO {

    private String title;
    private String description;
    private String material;
    private Long creatorId;
    private Long videoId;
    private List<Long> imageIds;
    private List<Long> tagIds;

}
