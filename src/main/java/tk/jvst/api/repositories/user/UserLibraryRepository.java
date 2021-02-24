package tk.jvst.api.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.user.UserLibrary;

public interface UserLibraryRepository extends JpaRepository<UserLibrary, Long> {
}
