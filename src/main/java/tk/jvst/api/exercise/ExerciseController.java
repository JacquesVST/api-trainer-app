package tk.jvst.api.exercise;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.exercise.dto.ExerciseCreateDTO;

import java.util.List;

@Api(value = "Exercise", tags = {"Exercise"})
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/creator")
    public ResponseEntity<List<Exercise>> findAllExercisesByCreator(@RequestParam Long id) {
        List<Exercise> exercises = this.exerciseService.findAllExercisesByCreator(id);
        return ResponseEntity.ok(exercises);
    }

    @GetMapping
    public ResponseEntity<Exercise> findExerciseById(@RequestParam Long id) {
        Exercise exercise = this.exerciseService.findById(id);
        return ResponseEntity.ok(exercise);
    }

    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody ExerciseCreateDTO exerciseCreateDTO) {
        Exercise exercise = this.exerciseService.createExercise(exerciseCreateDTO);
        return ResponseEntity.status(201).body(exercise);
    }

    @PutMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody ExerciseCreateDTO exerciseCreateDTO, @RequestParam Long id) {
        Exercise exercise = this.exerciseService.updateExercise(exerciseCreateDTO, id);
        return ResponseEntity.ok(exercise);
    }
}
