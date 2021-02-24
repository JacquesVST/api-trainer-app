package tk.jvst.api.repositories.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.exercise.ExerciseImages;

public interface ExerciseImagesRepository extends JpaRepository<ExerciseImages, Long> {
}
