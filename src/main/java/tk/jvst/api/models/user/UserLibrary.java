package tk.jvst.api.models.user;

import lombok.Data;
import tk.jvst.api.models.training.Training;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_library")
public class UserLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "endUser")
    private User endUser;
    @ManyToOne(targetEntity = Training.class)
    @JoinColumn(name = "training")
    private Training training;
    private Timestamp obtained;
    private boolean favorite;

}
