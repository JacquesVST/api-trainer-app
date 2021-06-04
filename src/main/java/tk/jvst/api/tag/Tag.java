package tk.jvst.api.tag;

import lombok.Data;
import tk.jvst.api.generic.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tag")
public class Tag extends BaseEntity {

    private String description;
    private String color;

}
