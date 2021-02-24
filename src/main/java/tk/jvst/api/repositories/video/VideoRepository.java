package tk.jvst.api.repositories.video;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.video.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
