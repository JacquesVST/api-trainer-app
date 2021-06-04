package tk.jvst.api.activity;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Activity", tags = {"Activity"})
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    public ActivityService service;

}
