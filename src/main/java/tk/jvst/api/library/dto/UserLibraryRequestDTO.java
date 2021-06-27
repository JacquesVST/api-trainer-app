package tk.jvst.api.library.dto;

import lombok.Data;
import tk.jvst.api.library.UserLibrary;
import tk.jvst.api.training.Training;
import tk.jvst.api.user.User;
import tk.jvst.api.util.DateTimeUtilities;

import java.util.Objects;

@Data
public class UserLibraryRequestDTO {

    private Long id;
    private Long userId;
    private Long trainingId;
    private String obtained;
    private boolean favorite;

    public UserLibrary toModel() {
        User user = null;
        if (Objects.nonNull(userId)) {
            user = User.builder().id(userId).build();
        }

        Training training = null;
        if (Objects.nonNull(trainingId)) {
            training = Training.builder().id(trainingId).build();
        }

        return UserLibrary.builder()
                .id(id)
                .endUser(user)
                .training(training)
                .obtained(DateTimeUtilities.stringDateToTimestamp(obtained))
                .favorite(favorite)
                .build();
    }
}
