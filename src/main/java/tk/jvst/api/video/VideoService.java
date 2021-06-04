package tk.jvst.api.video;

import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;

@Service
public class VideoService extends BaseService<Video> {

    public VideoService(BaseRepository<Video> repository) {
        super(repository);
    }

}
