package tk.jvst.api.activity;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.activity.dto.ActivityRequestDTO;

import java.util.List;

@Api(value = "Activity", tags = {"Activity"})
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    public ActivityService service;

    @GetMapping
    public ResponseEntity<List<Activity>> getActivitiesByTraining(@RequestParam Long trainingId) {
        return ResponseEntity.ok(service.findAllByTraining(trainingId));
    }

    @PostMapping
    public ResponseEntity<Activity> persistActivity(@RequestBody ActivityRequestDTO activityRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.persistActivity(activityRequestDTO));
    }

    @PostMapping("/list")
    public ResponseEntity<List<Activity>> persistActivities(@RequestBody List<ActivityRequestDTO> activityRequestDTOList) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.persistActivities(activityRequestDTOList));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteActivity(@RequestParam Long activityId) {
        service.deleteById(activityId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
