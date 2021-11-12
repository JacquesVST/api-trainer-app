package tk.jvst.api.comment;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.session.Session;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment> {

    List<Comment> findAllBySession(Session session);

}
