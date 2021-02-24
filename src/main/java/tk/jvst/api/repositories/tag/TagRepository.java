package tk.jvst.api.repositories.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.jvst.api.models.tag.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
