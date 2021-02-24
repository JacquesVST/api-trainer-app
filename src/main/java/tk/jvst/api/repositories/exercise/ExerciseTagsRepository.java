package tk.jvst.api.repositories.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.exercise.ExerciseTags;

public interface ExerciseTagsRepository extends JpaRepository<ExerciseTags, Long> {
}
