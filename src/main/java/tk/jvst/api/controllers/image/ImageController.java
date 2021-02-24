package tk.jvst.api.controllers.image;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.jvst.api.services.image.ImageService;

@Api(value = "Image", tags = {"Image"})
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
}
