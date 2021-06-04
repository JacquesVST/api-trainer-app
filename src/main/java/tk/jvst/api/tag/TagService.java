package tk.jvst.api.tag;


import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;

@Service
public class TagService extends BaseService<Tag> {

    public TagService(BaseRepository<Tag> repository) {
        super(repository);
    }

}
