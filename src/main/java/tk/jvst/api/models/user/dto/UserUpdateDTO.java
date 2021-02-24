package tk.jvst.api.models.user.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birth;
}
