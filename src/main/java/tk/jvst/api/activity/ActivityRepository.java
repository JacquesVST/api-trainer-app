package tk.jvst.api.activity;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.training.Training;

import java.util.List;

public interface ActivityRepository extends BaseRepository<Activity> {

    List<Activity> findAllByTraining(Training training);

    Long countByTraining(Training training);
}
