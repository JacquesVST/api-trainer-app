package tk.jvst.api.repositories.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.exercise.Exercise;
import tk.jvst.api.models.user.User;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findAllByCreator(User creator);

    Optional<Exercise> findByCreatorAndTitle(User creator, String title);
}
