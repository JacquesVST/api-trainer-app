package tk.jvst.api.models.session;

import lombok.Data;
import tk.jvst.api.models.user.UserLibrary;

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
    private Timestamp finish;
    private String observations;
    @ManyToOne(targetEntity = UserLibrary.class)
    @JoinColumn(name = "userLibrary")
    private UserLibrary userLibrary;

}
