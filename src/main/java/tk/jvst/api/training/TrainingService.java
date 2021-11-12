package tk.jvst.api.training;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import tk.jvst.api.file.FileService;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.tag.TagService;
import tk.jvst.api.training.dto.TrainingRequestDTO;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TrainingService extends BaseService<Training> {

    public TrainingService(BaseRepository<Training> repository) {
        super(repository);
    }

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Override
    public Training preProcess(Training obj) {
        obj.setCreator(userService.findById(obj.getCreator().getId()));
        if (Objects.nonNull(obj.getPicture())) {
            obj.setPicture(fileService.findById(obj.getPicture().getId()));
        }
        if (Strings.isNullOrEmpty(obj.getCode())) {
            String code;
            do {
                code = String.format("%06x", new Random().nextInt(0xffffff + 1));
            } while (trainingRepository.findByCode(code).isPresent());
            obj.setCode(code);
        }
        obj.setTags(obj.getTags().stream().map(tag -> tagService.findById(tag.getId())).collect(Collectors.toList()));
        return obj;
    }

    public List<Training> findAllTrainingsByCreator(Long creatorId) {
        User creator = this.userService.findById(creatorId);
        return this.trainingRepository.findAllByCreator(creator);
    }

    public List<Training> findAllPublic() {
        return findAll().stream().filter(training -> Objects.nonNull(training.getPublished())).collect(Collectors.toList());
    }

    public Training persistTraining(TrainingRequestDTO trainingRequestDTO) {
        return save(trainingRequestDTO.toModel());
    }

    public Training findByCode(String code) {
        Optional<Training> entity = trainingRepository.findByCode(code);
        if (entity.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return entity.get();
    }

}
