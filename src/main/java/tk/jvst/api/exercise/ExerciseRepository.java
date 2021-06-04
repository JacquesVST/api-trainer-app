package tk.jvst.api.exercise;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.user.User;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends BaseRepository<Exercise> {

    List<Exercise> findAllByCreator(User creator);

    Optional<Exercise> findByCreatorAndTitle(User creator, String title);
}
