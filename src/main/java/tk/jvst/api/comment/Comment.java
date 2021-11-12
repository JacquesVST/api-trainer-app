package tk.jvst.api.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tk.jvst.api.file.File;
import tk.jvst.api.generic.BaseEntity;
import tk.jvst.api.session.Session;
import tk.jvst.api.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    private String text;
    private Timestamp posted;
    private Boolean deleted;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne(targetEntity = Session.class)
    @JoinColumn(name = "session")
    private Session session;

    @JsonIgnoreProperties("data")
    @ManyToOne(targetEntity = File.class)
    @JoinColumn(name = "media")
    private File media;
}
