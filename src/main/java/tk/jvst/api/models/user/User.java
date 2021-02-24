package tk.jvst.api.models.user;

import lombok.Data;
import tk.jvst.api.models.image.Image;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String pass;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private Timestamp birth;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private boolean active;
    @ManyToOne(targetEntity = Image.class)
    @JoinColumn(name = "picture")
    private Image picture;
}
