package tk.jvst.api.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.comment.dto.CommentRequestDTO;
import tk.jvst.api.file.FileService;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.session.Session;
import tk.jvst.api.session.SessionService;
import tk.jvst.api.user.UserService;

import java.util.List;
import java.util.Objects;

@Service
public class CommentService extends BaseService<Comment> {

    public CommentService(BaseRepository<Comment> repository) {
        super(repository);
    }

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Override
    public Comment preProcess(Comment obj){
        obj.setAuthor(userService.findById(obj.getAuthor().getId()));
        obj.setSession(sessionService.findById(obj.getSession().getId()));
        if (Objects.nonNull(obj.getMedia())) {
            obj.setMedia(fileService.findById(obj.getMedia().getId()));
        }
        return obj;
    }

    public List<Comment> findAllCommentsBySession(Long sessionId) {
        Session session = this.sessionService.findById(sessionId);
        return this.commentRepository.findAllBySession(session);
    }

    public Comment persistComment(CommentRequestDTO commentRequestDTO) {
        return save(commentRequestDTO.toModel());
    }

    public void deleteComment(Long commentId){
        Comment comment = findById(commentId);
        comment.setDeleted(true);
        comment.setMedia(null);
        comment.setText(null);
        save(comment);
    }

}
