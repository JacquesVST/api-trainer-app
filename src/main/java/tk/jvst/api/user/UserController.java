package tk.jvst.api.user;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.user.dto.LoginDTO;
import tk.jvst.api.user.dto.UserRequestDTO;

import java.util.List;

@Api(value = "User", tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<User> findById(@RequestParam Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registerUser(userRequestDTO));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(userRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.login(loginDTO));
    }

    @PostMapping("/check-username")
    public ResponseEntity<Boolean> checkUsernameAvailability(@RequestBody String username) {
        return ResponseEntity.status(HttpStatus.OK).body(service.checkUsernameAvailability(username));
    }

    @GetMapping("/modify-user-type")
    public ResponseEntity<User> modifyUserType(@RequestParam Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.modifyUserType(userId));
    }

}
