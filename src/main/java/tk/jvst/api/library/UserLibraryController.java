package tk.jvst.api.library;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserService;
import tk.jvst.api.user.dto.LoginDTO;
import tk.jvst.api.user.dto.UserDTO;
import tk.jvst.api.user.dto.UserRegisterDTO;

import java.util.List;

@Api(value = "User Library", tags = {"User Library"})
@RestController
@RequestMapping("/user-library")
public class UserLibraryController {

    @Autowired
    private UserLibraryService service;

    @GetMapping
    public ResponseEntity<List<UserLibrary>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
