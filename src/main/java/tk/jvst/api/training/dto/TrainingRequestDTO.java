package tk.jvst.api.training.dto;

import lombok.Data;
import tk.jvst.api.file.File;
import tk.jvst.api.training.Training;
import tk.jvst.api.user.User;
import tk.jvst.api.util.DateTimeUtilities;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class TrainingRequestDTO {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer duration;
    private String published;
    private Long creatorId;
    private Long pictureId;

    public Training toModel() {
        File picture = null;
        if (Objects.nonNull(pictureId)) {
            picture = File.builder().id(pictureId).build();
        }

        return Training.builder()
                .id(id)
                .title(title)
                .description(description)
                .price(price)
                .duration(duration)
                .published(DateTimeUtilities.stringDateToTimestamp(published))
                .creator(User.builder().id(creatorId).build())
                .picture(picture)
                .build();
    }

}
