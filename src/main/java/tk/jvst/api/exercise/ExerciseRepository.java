package tk.jvst.api.exercise;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.user.User;

import java.util.List;

public interface ExerciseRepository extends BaseRepository<Exercise> {

    List<Exercise> findAllByCreator(User creator);

}
