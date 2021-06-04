package tk.jvst.api.training;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Training", tags = {"Training"})
@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/creator")
    public ResponseEntity<List<Training>> findAllExercisesByCreator(@RequestParam Long id) {
        List<Training> trainings = this.trainingService.findAllExercisesByCreator(id);
        return ResponseEntity.ok(trainings);
    }

}
