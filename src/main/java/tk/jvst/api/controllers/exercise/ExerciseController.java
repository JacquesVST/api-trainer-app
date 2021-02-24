package tk.jvst.api.controllers.exercise;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.jvst.api.services.exercise.ExerciseService;

@Api(value = "Exercise", tags = {"Exercise"})
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;
}
