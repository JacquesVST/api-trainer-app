package tk.jvst.api.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.exercise.dto.ExerciseRequestDTO;
import tk.jvst.api.file.FileService;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.tag.TagService;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService extends BaseService<Exercise> {

    public ExerciseService(BaseRepository<Exercise> repository) {
        super(repository);
    }

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Override
    public Exercise preProcess(Exercise obj) {
        obj.setCreator(userService.findById(obj.getCreator().getId()));
        obj.setFiles((obj.getFiles().stream().map(file -> fileService.findById(file.getId())).collect(Collectors.toList())));
        obj.setTags((obj.getTags().stream().map(tag -> tagService.findById(tag.getId())).collect(Collectors.toList())));
        return obj;
    }

    public List<Exercise> findAllExercisesByCreator(Long creatorId) {
        User creator = this.userService.findById(creatorId);
        return this.exerciseRepository.findAllByCreator(creator);
    }

    public Exercise persistExercise(ExerciseRequestDTO exerciseRequestDTO) {
        return save(exerciseRequestDTO.toModel());
    }

}
