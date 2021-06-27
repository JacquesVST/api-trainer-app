package tk.jvst.api.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.activity.dto.ActivityRequestDTO;
import tk.jvst.api.exercise.ExerciseService;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.training.Training;
import tk.jvst.api.training.TrainingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService extends BaseService<Activity> {

    public ActivityService(BaseRepository<Activity> repository) {
        super(repository);
    }

    @Autowired
    private ActivityRepository repository;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private TrainingService trainingService;

    @Override
    public Activity preProcess(Activity obj) {
        obj.setExercise(exerciseService.findById(obj.getExercise().getId()));
        obj.setTraining(trainingService.findById(obj.getTraining().getId()));
        return obj;
    }

    public List<Activity> findAllByTraining(Long trainingId) {
        Training training = trainingService.findById(trainingId);
        return repository.findAllByTraining(training);
    }

    public Activity persistActivity(ActivityRequestDTO activityRequestDTO) {
        return save(activityRequestDTO.toModel());
    }

    public List<Activity> persistActivities(List<ActivityRequestDTO> activityRequestDTOList) {
        List<Activity> activities = activityRequestDTOList.stream().map(ActivityRequestDTO::toModel).collect(Collectors.toList());
        return saveAll(activities);
    }
}
