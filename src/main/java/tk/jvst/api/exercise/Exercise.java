package tk.jvst.api.exercise;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.file.File;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.tag.Tag;
import tk.jvst.api.user.User;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "exercise")
public class Exercise extends BaseEntity {

    private String title;
    private String description;
    private String material;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "creator")
    private User creator;
    @ManyToMany(targetEntity = File.class)
    private List<File> files;
    @ManyToMany(targetEntity = Tag.class)
    private List<Tag> tags;
}
