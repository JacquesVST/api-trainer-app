package tk.jvst.api.tag.dto;

import lombok.Data;
import tk.jvst.api.tag.Tag;

@Data
public class TagRequestDTO {

    private Long id;
    private String description;
    private String color;

    public Tag toModel() {
        return Tag.builder()
                .id(id)
                .description(description)
                .color(color)
                .build();
    }
}
