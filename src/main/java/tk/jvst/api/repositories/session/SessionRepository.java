package tk.jvst.api.repositories.session;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.session.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
