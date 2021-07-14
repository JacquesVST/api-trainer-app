package tk.jvst.api.training;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.training.dto.TrainingRequestDTO;

import java.util.List;

@Api(value = "Training", tags = {"Training"})
@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/creator")
    public ResponseEntity<List<Training>> findAllTrainingsByCreator(@RequestParam Long creatorId) {
        List<Training> trainings = this.trainingService.findAllTrainingsByCreator(creatorId);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Training>> findAllPublic() {
        List<Training> trainings = this.trainingService.findAllPublic();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping
    public ResponseEntity<Training> findTrainingById(@RequestParam Long trainingId) {
        Training training = this.trainingService.findById(trainingId);
        return ResponseEntity.ok(training);
    }

    @PostMapping
    public ResponseEntity<Training> persistTraining(@RequestBody TrainingRequestDTO trainingRequestDTO) {
        Training training = this.trainingService.persistTraining(trainingRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(training);
    }

}
