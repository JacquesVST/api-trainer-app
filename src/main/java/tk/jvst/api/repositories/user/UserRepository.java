package tk.jvst.api.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.user.User;
import tk.jvst.api.models.user.UserType;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<User> findByType(UserType type);
}
