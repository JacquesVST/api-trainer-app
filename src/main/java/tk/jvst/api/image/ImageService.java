package tk.jvst.api.image;

import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;

@Service
public class ImageService extends BaseService<Image> {

    public ImageService(BaseRepository<Image> repository) {
        super(repository);
    }

}
