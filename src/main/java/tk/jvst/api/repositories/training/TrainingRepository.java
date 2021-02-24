package tk.jvst.api.repositories.training;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.training.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
