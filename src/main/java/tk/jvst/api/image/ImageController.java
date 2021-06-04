package tk.jvst.api.image;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Image", tags = {"Image"})
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
}
