package tk.jvst.api.services.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.models.tag.Tag;
import tk.jvst.api.repositories.tag.TagRepository;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return this.tagRepository.findAll();
    }
}
