package tk.jvst.api.services.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.repositories.exercise.ExerciseImagesRepository;
import tk.jvst.api.repositories.exercise.ExerciseRepository;
import tk.jvst.api.repositories.exercise.ExerciseTagsRepository;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseImagesRepository exerciseImagesRepository;

    @Autowired
    private ExerciseTagsRepository exerciseTagsRepository;
}
