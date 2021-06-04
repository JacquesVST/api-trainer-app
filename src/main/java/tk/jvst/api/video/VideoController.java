package tk.jvst.api.video;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Video", tags = {"Video"})
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;
}
