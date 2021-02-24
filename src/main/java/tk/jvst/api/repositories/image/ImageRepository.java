package tk.jvst.api.repositories.image;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.image.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
