package tk.jvst.api.user;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.user.dto.LoginDTO;
import tk.jvst.api.user.dto.UserDTO;
import tk.jvst.api.user.dto.UserRegisterDTO;
import tk.jvst.api.user.dto.UserUpdateDTO;

import java.util.List;

@Api(value = "User", tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(userService.registerUser(userRegisterDTO)));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {
        UserDTO user = new UserDTO(userService.login(loginDTO));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(userService.updateUser(userUpdateDTO)));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<UserDTO>> getUserByType(@PathVariable UserType type) {
        return ResponseEntity.status(HttpStatus.OK).body(UserDTO.convertList(userService.findByType(type)));
    }

    @GetMapping("/toggle/{userId}")
    public ResponseEntity<UserDTO> toggleUserActiveStatus(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(userService.toggleUserActiveStatus(userId)));
    }

    @PostMapping("/check-username")
    public ResponseEntity<Boolean> checkUsernameAvailability(@RequestBody String username) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.checkUsernameAvailability(username));
    }

}
