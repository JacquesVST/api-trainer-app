package tk.jvst.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserType;
import tk.jvst.api.util.DateTimeUtilities;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String pass;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birth;
    private UserType type;
    private boolean active;

    public UserDTO(User user) {
        id = user.getId();
        username = user.getUsername();
        pass = user.getPass();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        phoneNumber = user.getPhoneNumber();
        birth = DateTimeUtilities.timestampToStringDate(user.getBirth());
        type = user.getType();
        active = user.isActive();
    }

    public static List<UserDTO> convertList(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
