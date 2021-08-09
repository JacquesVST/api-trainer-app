package tk.jvst.api.session;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.session.dto.SessionRequestDTO;

import java.util.List;

@Api(value = "Session", tags = {"Session"})
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping()
    public ResponseEntity<Session> findById(@RequestParam Long sessionId) {
        return ResponseEntity.ok(sessionService.findById(sessionId));
    }

    @GetMapping("/user")
    public ResponseEntity<List<Session>> findAllByUser(@RequestParam Long userId) {
        return ResponseEntity.ok(sessionService.findAllByUser(userId));
    }

    @GetMapping("/creator")
    public ResponseEntity<List<Session>> findAllByCreator(@RequestParam Long creatorId) {
        return ResponseEntity.ok(sessionService.findAllByCreator(creatorId));
    }

    @PostMapping
    public ResponseEntity<Session> persistSession(@RequestBody SessionRequestDTO sessionRequestDTO) {
        Session session = this.sessionService.persistSession(sessionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(session);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSession(@RequestParam Long sessionId) {
        this.sessionService.deleteById(sessionId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
