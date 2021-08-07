package tk.jvst.api.session.dto;

import lombok.Data;
import tk.jvst.api.library.UserLibrary;
import tk.jvst.api.session.Session;

import java.sql.Timestamp;
import java.util.Objects;

@Data
public class SessionRequestDTO {

    private Long id;
    private Integer duration;
    private Timestamp start;
    private Timestamp finish;
    private String observations;
    private boolean sent;
    private Long userLibraryId;

    public Session toModel() {
        UserLibrary userLibrary = null;
        if (Objects.nonNull(userLibraryId)) {
            userLibrary = UserLibrary.builder().id(userLibraryId).build();
        }

        return Session.builder()
                .id(id)
                .duration(duration)
                .start(start)
                .finish(finish)
                .observations(observations)
                .sent(sent)
                .userLibrary(userLibrary)
                .build();
    }

}
