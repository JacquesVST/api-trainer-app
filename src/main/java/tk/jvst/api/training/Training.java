package tk.jvst.api.training;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.file.File;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "training")
public class Training extends BaseEntity {

    private String title;

    private String description;

    private BigDecimal price;

    private Integer duration;

    private Timestamp published;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "creator")
    private User creator;

    @ManyToOne(targetEntity = File.class)
    @JoinColumn(name = "picture")
    private File picture;
}
