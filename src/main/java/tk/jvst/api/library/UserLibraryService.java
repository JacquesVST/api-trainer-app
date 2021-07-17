package tk.jvst.api.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.library.dto.UserLibraryRequestDTO;
import tk.jvst.api.training.Training;
import tk.jvst.api.training.TrainingService;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserService;
import tk.jvst.api.util.literals.Validation;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserLibraryService extends BaseService<UserLibrary> {

    public UserLibraryService(BaseRepository<UserLibrary> repository) {
        super(repository);
    }

    @Autowired
    private UserLibraryRepository userLibraryRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TrainingService trainingService;

    @Override
    public UserLibrary preProcess(UserLibrary obj) {
        obj.setEndUser(userService.findById(obj.getEndUser().getId()));
        obj.setTraining(trainingService.findById(obj.getTraining().getId()));
        if (Objects.isNull(obj.getObtained())) {
            obj.setObtained(Timestamp.valueOf(LocalDateTime.now()));
        }
        return obj;
    }

    public UserLibrary persistUserLibrary(UserLibraryRequestDTO userLibraryRequestDTO) {
        User user = userService.findById(userLibraryRequestDTO.getUserId());
        Training training = trainingService.findById(userLibraryRequestDTO.getTrainingId());
        if (Objects.isNull(userLibraryRequestDTO.getId()) && userLibraryRepository.findByEndUserAndTraining(user, training).isPresent()) {
            throw new DuplicateKeyException(Validation.USER_LIBRARY_EXISTS);
        }
        return save(userLibraryRequestDTO.toModel());
    }

    public List<UserLibrary> findAllByUser(Long userId) {
        List<UserLibrary> userLibraries = userLibraryRepository.findAllByEndUser(userService.findById(userId));
        Collections.sort(userLibraries);
        return userLibraries;
    }

    public List<UserLibrary> findAllByTraining(Long trainingId) {
        return userLibraryRepository.findAllByTraining(trainingService.findById(trainingId));
    }

    public UserLibrary findByEndUserAndTraining(Long userId, Long trainingId) {
        return userLibraryRepository.findByEndUserAndTraining(userService.findById(userId), trainingService.findById(trainingId)).orElse(null);
    }


}
