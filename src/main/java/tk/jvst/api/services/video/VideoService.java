package tk.jvst.api.services.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.repositories.video.VideoRepository;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
}
