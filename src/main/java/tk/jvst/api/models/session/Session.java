package tk.jvst.api.models.session;

import lombok.Data;
import tk.jvst.api.models.training.Training;
import tk.jvst.api.models.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer duration;
    private Timestamp start;
    private Timestamp end;
    private String observations;
    @ManyToOne(targetEntity = Training.class)
    @JoinColumn(name = "training")
    private Training training;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user")
    private User user;

}
