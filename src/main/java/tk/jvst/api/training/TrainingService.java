package tk.jvst.api.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserService;

import java.util.List;

@Service
public class TrainingService extends BaseService<Training> {

    public TrainingService(BaseRepository<Training> repository) {
        super(repository);
    }

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private UserService userService;

    public List<Training> findAllExercisesByCreator(Long creatorId) {
        User creator = this.userService.findById(creatorId);
        return this.trainingRepository.findAllByCreator(creator);
    }

}
