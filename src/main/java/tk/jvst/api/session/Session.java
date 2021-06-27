package tk.jvst.api.session;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.library.UserLibrary;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "session")
public class Session extends BaseEntity {

    private Integer duration;

    private Timestamp start;

    private Timestamp finish;

    private String observations;

    @ManyToOne(targetEntity = UserLibrary.class)
    @JoinColumn(name = "userLibrary")
    private UserLibrary userLibrary;

}
