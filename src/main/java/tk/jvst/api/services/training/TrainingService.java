package tk.jvst.api.services.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.repositories.training.TrainingRepository;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;
}
