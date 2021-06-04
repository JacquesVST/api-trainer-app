package tk.jvst.api.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tk.jvst.api.exercise.dto.ExerciseCreateDTO;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.image.ImageService;
import tk.jvst.api.tag.TagService;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserService;
import tk.jvst.api.util.literals.Validation;
import tk.jvst.api.video.VideoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ExerciseService extends BaseService<Exercise> {

    public ExerciseService(BaseRepository<Exercise> repository) {
        super(repository);
    }

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

    public Exercise createExercise(ExerciseCreateDTO exerciseCreateDTO) {
        User creator = this.userService.findById(exerciseCreateDTO.getCreatorId());
        if (this.exerciseRepository.findByCreatorAndTitle(creator, exerciseCreateDTO.getTitle()).isPresent()) {
            throw new DuplicateKeyException(Validation.EXERCISE_TITLE_EXITS);
        }
        Exercise exercise = this.convertCreateDTOtoExercise(exerciseCreateDTO, new Exercise());
        return save(exercise);
    }

    public Exercise updateExercise(ExerciseCreateDTO exerciseCreateDTO, Long id) {
        Exercise existing = this.findById(id);
        User creator = this.userService.findById(exerciseCreateDTO.getCreatorId());
        if (this.exerciseRepository.findByCreatorAndTitle(creator, exerciseCreateDTO.getTitle()).isPresent()) {
            throw new DuplicateKeyException(Validation.EXERCISE_TITLE_EXITS);
        }
        Exercise exercise = this.convertCreateDTOtoExercise(exerciseCreateDTO, existing);
        return save(exercise);
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
