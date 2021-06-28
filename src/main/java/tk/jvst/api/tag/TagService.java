package tk.jvst.api.tag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.util.literals.Validation;

import java.util.Optional;

@Service
public class TagService extends BaseService<Tag> {

    public TagService(BaseRepository<Tag> repository) {
        super(repository);
    }

    @Autowired
    public TagRepository tagRepository;

    public Tag persistTag(Tag tag){
        if(tagRepository.findByDescription(tag.getDescription()).isPresent()){
            throw new DuplicateKeyException(Validation.TAG_EXISTS);
        }
        return save(tag);
    }

}
