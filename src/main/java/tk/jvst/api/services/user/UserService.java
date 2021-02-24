package tk.jvst.api.services.user;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import tk.jvst.api.models.user.User;
import tk.jvst.api.models.user.UserType;
import tk.jvst.api.models.user.dto.LoginDTO;
import tk.jvst.api.models.user.dto.UserRegisterDTO;
import tk.jvst.api.models.user.dto.UserUpdateDTO;
import tk.jvst.api.repositories.user.UserLibraryRepository;
import tk.jvst.api.repositories.user.UserRepository;
import tk.jvst.api.util.DateTimeUtilities;
import tk.jvst.api.util.HashUtils;
import tk.jvst.api.util.Validation;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLibraryRepository userLibraryRepository;

    public User findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return user.get();
    }

    public User registerUser(UserRegisterDTO userRegisterDTO) {
        if (userRepository.findByEmail(userRegisterDTO.getUsername()).isPresent()) {
            throw new DuplicateKeyException(Validation.USERNAME_EXISTS);
        }
        if (userRepository.findByEmail(userRegisterDTO.getEmail()).isPresent()) {
            throw new DuplicateKeyException(Validation.EMAIL_EXISTS);
        }
        User user = userRegisterDTO.safeConvert();
        user.setPass(HashUtils.stringToSha256(user.getPass()));
        user.setActive(true);
        return userRepository.save(user);
    }

    public User updateUser(UserUpdateDTO userUpdateDTO) {
        if (userRepository.findByEmail(userUpdateDTO.getEmail()).isPresent()) {
            throw new DuplicateKeyException(Validation.EMAIL_EXISTS);
        }
        User user = findById(userUpdateDTO.getId());

        if (Strings.isNullOrEmpty(userUpdateDTO.getFirstName())) {
            user.setFirstName(userUpdateDTO.getFirstName());
        }

        if (Strings.isNullOrEmpty(userUpdateDTO.getLastName())) {
            user.setLastName(userUpdateDTO.getLastName());
        }

        if (Strings.isNullOrEmpty(userUpdateDTO.getEmail())) {
            user.setEmail(userUpdateDTO.getEmail());
        }

        if (Strings.isNullOrEmpty(userUpdateDTO.getPhoneNumber())) {
            user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
        }

        if (Strings.isNullOrEmpty(userUpdateDTO.getBirth())) {
            user.setBirth(DateTimeUtilities.stringDateToTimestamp(userUpdateDTO.getBirth()));
        }

        return userRepository.save(user);
    }

    public User login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByUsername(loginDTO.getUsername());
        if (user.isPresent()) {
            if (HashUtils.stringToSha256(loginDTO.getPass()).equals(user.get().getPass())) {
                System.out.println(user.get());
                return user.get();
            }
        } else {
            throw new EmptyResultDataAccessException(1);
        }
        return null;
    }

    public User toggleUserActiveStatus(Long userId) {
        User user = findById(userId);
        user.setActive(!user.isActive());
        return userRepository.save(user);
    }

    public List<User> findByType(UserType type) {
        return userRepository.findByType(type);
    }

    public Boolean checkUsernameAvailability(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }
}
