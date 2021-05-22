package tk.jvst.api.services.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import tk.jvst.api.models.image.Image;
import tk.jvst.api.repositories.image.ImageRepository;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image findById(Long imageId){
        Optional<Image> image = this.imageRepository.findById(imageId);
        if(image.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        return image.get();
    }
}
