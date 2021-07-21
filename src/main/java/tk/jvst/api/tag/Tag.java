package tk.jvst.api.tag;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.generic.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Locale;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "tag")
public class Tag extends BaseEntity implements Comparable<Tag> {

    private String description;

    private String color;

    @Override
    public int compareTo(Tag o) {
        return this.getDescription().toLowerCase(Locale.ROOT).compareTo(o.getDescription().toLowerCase(Locale.ROOT));
    }

}
