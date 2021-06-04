package tk.jvst.api.user;

import lombok.Data;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.training.Training;

import javax.persistence.*;
import java.sql.Timestamp;

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
