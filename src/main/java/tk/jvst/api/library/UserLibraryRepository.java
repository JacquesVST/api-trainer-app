package tk.jvst.api.library;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.training.Training;
import tk.jvst.api.user.User;

import java.util.List;
import java.util.Optional;

public interface UserLibraryRepository extends BaseRepository<UserLibrary> {

    List<UserLibrary> findAllByEndUser(User endUser);

    List<UserLibrary> findAllByTraining(Training training);

    Optional<UserLibrary> findByEndUserAndTraining(User endUser, Training training);
}
