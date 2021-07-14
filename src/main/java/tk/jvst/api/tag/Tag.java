package tk.jvst.api.tag;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.generic.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "tag")
public class Tag extends BaseEntity {

    private String description;

    private String color;

}
