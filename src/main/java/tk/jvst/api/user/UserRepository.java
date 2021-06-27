package tk.jvst.api.user;

import tk.jvst.api.generic.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
