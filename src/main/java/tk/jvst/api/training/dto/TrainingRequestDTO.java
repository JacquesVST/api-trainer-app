package tk.jvst.api.training.dto;

import lombok.Data;
import tk.jvst.api.file.File;
import tk.jvst.api.tag.Tag;
import tk.jvst.api.training.Training;
import tk.jvst.api.user.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class TrainingRequestDTO {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer duration;
    private boolean published;
    private Long creatorId;
    private Long pictureId;
    private Set<Long> tagIds;

    public Training toModel() {
        File picture = null;
        if (Objects.nonNull(pictureId)) {
            picture = File.builder().id(pictureId).build();
        }

        List<Tag> tags = new ArrayList<>();
        if (Objects.nonNull(tagIds)) {
            tags = tagIds.stream().map(tagId -> Tag.builder().id(tagId).build()).collect(Collectors.toList());
        }

        Timestamp timestamp = null;
        if (published) {
            timestamp = Timestamp.valueOf(LocalDateTime.now());
        }

        return Training.builder()
                .id(id)
                .title(title)
                .description(description)
                .price(price)
                .duration(duration)
                .published(timestamp)
                .creator(User.builder().id(creatorId).build())
                .picture(picture)
                .tags(tags)
                .build();
    }

}
