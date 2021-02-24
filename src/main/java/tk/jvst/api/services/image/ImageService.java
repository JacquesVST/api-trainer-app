package tk.jvst.api.services.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.repositories.image.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
}
