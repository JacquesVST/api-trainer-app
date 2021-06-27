package tk.jvst.api.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.file.File;
import tk.jvst.api.generic.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
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

    @ManyToOne(targetEntity = File.class)
    @JoinColumn(name = "picture")
    private File picture;

}
