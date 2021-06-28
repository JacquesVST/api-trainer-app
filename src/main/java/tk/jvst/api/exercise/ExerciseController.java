package tk.jvst.api.exercise;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.exercise.dto.ExerciseRequestDTO;

import java.util.List;

@Api(value = "Exercise", tags = {"Exercise"})
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @GetMapping("/creator")
    public ResponseEntity<List<Exercise>> findAllExercisesByCreator(@RequestParam Long creatorId) {
        List<Exercise> exercises = service.findAllExercisesByCreator(creatorId);
        return ResponseEntity.ok(exercises);
    }

    @GetMapping
    public ResponseEntity<Exercise> findExerciseById(@RequestParam Long exerciseId) {
        Exercise exercise = service.findById(exerciseId);
        return ResponseEntity.ok(exercise);
    }

    @PostMapping
    public ResponseEntity<Exercise> persistExercise(@RequestBody ExerciseRequestDTO exerciseRequestDTO) {
        Exercise exercise = service.persistExercise(exerciseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercise);
    }

}
