package tk.jvst.api.user.dto;

import lombok.Data;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserType;

@Data
public class UserRegisterDTO {

    private String username;
    private String pass;
    private String firstName;
    private String lastName;
    private String email;
    private UserType type;

    public User safeConvert(){
        User user = new User();
        user.setUsername(username);
        user.setPass(pass);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setType(type);
        return user;
    }

}
