package tk.jvst.api.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.file.FileService;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.training.dto.TrainingRequestDTO;
import tk.jvst.api.user.User;
import tk.jvst.api.user.UserService;

import java.util.List;
import java.util.Objects;

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
    private UserService userService;

    @Override
    public Training preProcess(Training obj) {
        obj.setCreator(userService.findById(obj.getCreator().getId()));
        if (Objects.nonNull(obj.getPicture())) {
            obj.setPicture(fileService.findById(obj.getPicture().getId()));
        }
        return obj;
    }

    public List<Training> findAllTrainingsByCreator(Long creatorId) {
        User creator = this.userService.findById(creatorId);
        return this.trainingRepository.findAllByCreator(creator);
    }

    public Training persistTraining(TrainingRequestDTO trainingRequestDTO) {
        return save(trainingRequestDTO.toModel());
    }

}
