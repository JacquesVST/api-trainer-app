package tk.jvst.api.user;

import lombok.Data;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.image.Image;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {

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
