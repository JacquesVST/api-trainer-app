package tk.jvst.api.library;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.training.Training;
import tk.jvst.api.user.User;

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
@Table(name = "user_library")
public class UserLibrary extends BaseEntity {

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "endUser")
    private User endUser;

    @ManyToOne(targetEntity = Training.class)
    @JoinColumn(name = "training")
    private Training training;

    private Timestamp obtained;

    private boolean favorite;

}
