package tk.jvst.api.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.library.UserLibrary;
import tk.jvst.api.library.UserLibraryService;
import tk.jvst.api.session.dto.SessionRequestDTO;
import tk.jvst.api.training.Training;
import tk.jvst.api.training.TrainingService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SessionService extends BaseService<Session> {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private UserLibraryService userLibraryService;

    public SessionService(BaseRepository<Session> repository) {
        super(repository);
    }

    @Override
    public Session preProcess(Session obj) {
        obj.setUserLibrary(userLibraryService.findById(obj.getUserLibrary().getId()));
        if (Objects.isNull(obj.getStart())) {
            obj.setStart(Timestamp.valueOf(LocalDateTime.now()));
        }

        if (Objects.nonNull(obj.getId())) {
            obj.setFinish(Timestamp.valueOf(LocalDateTime.now()));
        }
        return obj;
    }

    public Session persistSession(SessionRequestDTO sessionRequestDTO) {
        return save(sessionRequestDTO.toModel());
    }

    public List<Session> findAllByUser(Long userId) {
        List<UserLibrary> userLibraries = userLibraryService.findAllByUser(userId);
        return this.sessionRepository.findByUserLibraryIn(userLibraries);
    }

    public List<Session> findAllByCreator(Long creatorId) {
        List<Training> trainings = trainingService.findAllTrainingsByCreator(creatorId);
        List<UserLibrary> userLibraries = new ArrayList<>();
        for (Training training : trainings) {
            userLibraries.addAll(userLibraryService.findAllByTraining(training.getId()));
        }
        return this.sessionRepository.findByUserLibraryIn(userLibraries);
    }

}
