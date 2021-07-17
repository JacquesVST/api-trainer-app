package tk.jvst.api.library;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.library.dto.UserLibraryRequestDTO;

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

    @PostMapping
    public ResponseEntity<UserLibrary> persistUserLibrary(@RequestBody UserLibraryRequestDTO userLibraryRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.persistUserLibrary(userLibraryRequestDTO));
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserLibrary>> findAllByUser(@RequestParam Long userId){
        return ResponseEntity.ok(service.findAllByUser(userId));
    }

    @GetMapping("/training")
    public ResponseEntity<List<UserLibrary>> findAllByTraining(@RequestParam Long trainingId){
        return ResponseEntity.ok(service.findAllByTraining(trainingId));
    }

    @GetMapping("/match")
    public ResponseEntity<UserLibrary> findByEndUserAndTraining(@RequestParam Long userId, @RequestParam Long trainingId){
        return ResponseEntity.ok(service.findByEndUserAndTraining(userId, trainingId));
    }
}
