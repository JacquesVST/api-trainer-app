package tk.jvst.api.exercise.dto;

import lombok.Data;
import tk.jvst.api.exercise.Exercise;
import tk.jvst.api.file.File;
import tk.jvst.api.tag.Tag;
import tk.jvst.api.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ExerciseRequestDTO {

    private Long id;
    private String title;
    private String description;
    private String material;
    private Long creatorId;
    private Set<Long> fileIds;
    private Set<Long> tagIds;

    public Exercise toModel() {
        List<File> files = new ArrayList<>();
        if(Objects.nonNull(fileIds)){
            files = fileIds.stream().map(fileId -> File.builder().id(fileId).build()).collect(Collectors.toList());
        }

        List<Tag> tags = new ArrayList<>();
        if(Objects.nonNull(tagIds)){
            tags = tagIds.stream().map(tagId -> Tag.builder().id(tagId).build()).collect(Collectors.toList());
        }

        return Exercise.builder()
                .id(id)
                .title(title)
                .description(description)
                .material(material)
                .creator(User.builder().id(creatorId).build())
                .files(files)
                .tags(tags)
                .build();
    }

}
