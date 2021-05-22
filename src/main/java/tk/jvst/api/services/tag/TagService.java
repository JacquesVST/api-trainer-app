package tk.jvst.api.services.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import tk.jvst.api.models.tag.Tag;
import tk.jvst.api.repositories.tag.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }

    public Tag findById(Long tagId) {
        Optional<Tag> tag = this.tagRepository.findById(tagId);
        if (tag.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return tag.get();
    }
}
