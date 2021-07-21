package tk.jvst.api.tag;

import tk.jvst.api.generic.BaseRepository;

import java.util.Optional;

public interface TagRepository extends BaseRepository<Tag> {

    Optional<Tag> findByDescriptionIgnoreCase(String description);
}
