package tk.jvst.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.user.dto.LoginDTO;
import tk.jvst.api.user.dto.UserRequestDTO;
import tk.jvst.api.util.HashUtilities;
import tk.jvst.api.util.literals.Validation;

import java.util.Optional;

@Service
public class UserService extends BaseService<User> {

    public UserService(BaseRepository<User> repository) {
        super(repository);
    }

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserRequestDTO userRequestDTO) {
        if (userRepository.findByEmail(userRequestDTO.getUsername()).isPresent()) {
            throw new DuplicateKeyException(Validation.USERNAME_EXISTS);
        }
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new DuplicateKeyException(Validation.EMAIL_EXISTS);
        }
        User user = userRequestDTO.toModel();
        user.setPass(HashUtilities.stringToSha256(user.getPass()));
        user.setActive(true);
        return save(user);
    }


    public User login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByUsername(loginDTO.getUsername());
        if (user.isPresent()) {
            if (HashUtilities.stringToSha256(loginDTO.getPass()).equals(user.get().getPass())) {
                return user.get();
            }
        } else {
            throw new EmptyResultDataAccessException(1);
        }
        return null;
    }

    public Boolean checkUsernameAvailability(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }
}
