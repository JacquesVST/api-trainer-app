package tk.jvst.api.user;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.user.dto.LoginDTO;
import tk.jvst.api.user.dto.UserDTO;
import tk.jvst.api.user.dto.UserRequestDTO;

import java.util.List;

@Api(value = "User", tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(service.registerUser(userRequestDTO)));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {
        UserDTO user = new UserDTO(service.login(loginDTO));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/check-username")
    public ResponseEntity<Boolean> checkUsernameAvailability(@RequestBody String username) {
        return ResponseEntity.status(HttpStatus.OK).body(service.checkUsernameAvailability(username));
    }

}
