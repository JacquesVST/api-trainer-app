package tk.jvst.api.repositories.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.activity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
