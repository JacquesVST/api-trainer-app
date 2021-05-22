package tk.jvst.api.services.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import tk.jvst.api.models.exercise.Exercise;
import tk.jvst.api.models.exercise.dto.ExerciseCreateDTO;
import tk.jvst.api.models.user.User;
import tk.jvst.api.repositories.exercise.ExerciseRepository;
import tk.jvst.api.services.image.ImageService;
import tk.jvst.api.services.tag.TagService;
import tk.jvst.api.services.user.UserService;
import tk.jvst.api.services.video.VideoService;
import tk.jvst.api.util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Autowired
    private VideoService videoService;

    public List<Exercise> findAllExercisesByCreator(Long creatorId) {
        User creator = this.userService.findById(creatorId);
        return this.exerciseRepository.findAllByCreator(creator);
    }

    public Exercise findById(Long exerciseId) {
        Optional<Exercise> exercise = this.exerciseRepository.findById(exerciseId);
        if (exercise.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return exercise.get();
    }

    public Exercise createExercise(ExerciseCreateDTO exerciseCreateDTO) {
        User creator = this.userService.findById(exerciseCreateDTO.getCreatorId());
        if (this.exerciseRepository.findByCreatorAndTitle(creator, exerciseCreateDTO.getTitle()).isPresent()) {
            throw new DuplicateKeyException(Validation.EXERCISE_TITLE_EXITS);
        }
        Exercise exercise = this.convertCreateDTOtoExercise(exerciseCreateDTO, new Exercise());
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(ExerciseCreateDTO exerciseCreateDTO, Long id) {
        Exercise existing = this.findById(id);
        User creator = this.userService.findById(exerciseCreateDTO.getCreatorId());
        if (this.exerciseRepository.findByCreatorAndTitle(creator, exerciseCreateDTO.getTitle()).isPresent()) {
            throw new DuplicateKeyException(Validation.EXERCISE_TITLE_EXITS);
        }
        Exercise exercise = this.convertCreateDTOtoExercise(exerciseCreateDTO, existing);
        return exerciseRepository.save(exercise);
    }

    public Exercise convertCreateDTOtoExercise(ExerciseCreateDTO exerciseCreateDTO, Exercise exercise) {
        exercise.setTitle(exerciseCreateDTO.getTitle());
        exercise.setDescription(exerciseCreateDTO.getDescription());
        exercise.setMaterial(exerciseCreateDTO.getMaterial());

        exercise.setCreator(this.userService.findById(exerciseCreateDTO.getCreatorId()));
        if (Objects.nonNull(exerciseCreateDTO.getVideoId())) {
            exercise.setVideo(this.videoService.findById(exerciseCreateDTO.getVideoId()));
        }

        if (Objects.nonNull(exerciseCreateDTO.getImageIds())) {
            exercise.setImages(new ArrayList<>());
            for (Long imageId : exerciseCreateDTO.getImageIds()) {
                exercise.getImages().add(this.imageService.findById(imageId));
            }
        }

        if (!exerciseCreateDTO.getTagIds().isEmpty()) {
            exercise.setTags(new ArrayList<>());
            for (Long tagId : exerciseCreateDTO.getTagIds()) {
                exercise.getTags().add(this.tagService.findById(tagId));
            }
        }

        return exercise;
    }

}
