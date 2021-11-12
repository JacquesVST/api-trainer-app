package tk.jvst.api.comment.dto;

import lombok.Data;
import tk.jvst.api.comment.Comment;
import tk.jvst.api.file.File;
import tk.jvst.api.session.Session;
import tk.jvst.api.user.User;

import java.sql.Timestamp;
import java.util.Objects;

@Data
public class CommentRequestDTO {

    private Long id;
    private String text;
    private Timestamp posted;
    private Long authorId;
    private Long sessionId;
    private Long mediaId;

    public Comment toModel() {
        File media = null;
        if(Objects.nonNull(mediaId)){
            media = File.builder().id(mediaId).build();
        }

        return Comment.builder()
                .id(id)
                .text(text)
                .posted(posted)
                .author(User.builder().id(authorId).build())
                .session(Session.builder().id(sessionId).build())
                .media(media)
                .build();
    }
}
