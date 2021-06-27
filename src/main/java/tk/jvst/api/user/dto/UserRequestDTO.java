package tk.jvst.api.user.dto;

import lombok.Data;
import tk.jvst.api.file.File;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserType;
import tk.jvst.api.util.DateTimeUtilities;

import java.util.Objects;

@Data
public class UserRequestDTO {

    private Long id;
    private String username;
    private String pass;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birth;
    private UserType type;
    private Long pictureId;

    public User toModel() {
        File picture = null;
        if (Objects.nonNull(pictureId)) {
            picture = File.builder().id(pictureId).build();
        }

        return User.builder()
                .id(id)
                .username(username)
                .pass(pass)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .birth(DateTimeUtilities.stringDateToTimestamp(birth))
                .type(type)
                .active(true)
                .picture(picture)
                .build();
    }

}
