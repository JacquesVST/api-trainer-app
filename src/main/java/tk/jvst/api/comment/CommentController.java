package tk.jvst.api.comment;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.comment.dto.CommentRequestDTO;

import java.util.List;

@Api(value = "Comment", tags = {"Comment"})
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/session")
    public ResponseEntity<List<Comment>> findAllCommentsBySession(@RequestParam Long sessionId) {
        List<Comment> comments = this.commentService.findAllCommentsBySession(sessionId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<Comment> persistComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        Comment comment = this.commentService.persistComment(commentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteComment(@RequestParam Long commentId) {
        this.commentService.deleteComment(commentId);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
