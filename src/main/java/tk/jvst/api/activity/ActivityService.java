package tk.jvst.api.activity;

import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;

@Service
public class ActivityService extends BaseService<Activity> {

    public ActivityService(BaseRepository<Activity> repository) {
        super(repository);
    }

}
