package tk.jvst.api.services.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import tk.jvst.api.models.video.Video;
import tk.jvst.api.repositories.video.VideoRepository;

import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Video findById(Long videoId) {
        Optional<Video> video = this.videoRepository.findById(videoId);
        if (video.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return video.get();
    }
}
