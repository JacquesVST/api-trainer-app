package tk.jvst.api.controllers.activity;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.jvst.api.models.activity.Activity;
import tk.jvst.api.services.activity.ActivityService;

@Api(value = "Activity", tags = {"Activity"})
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public Activity newActivity(){
        return new Activity();
    }
}
