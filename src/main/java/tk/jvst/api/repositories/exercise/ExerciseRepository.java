package tk.jvst.api.repositories.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.exercise.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
