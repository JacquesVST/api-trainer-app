package tk.jvst.api.training;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.user.User;

import java.util.List;
import java.util.Optional;

public interface TrainingRepository extends BaseRepository<Training> {

    List<Training> findAllByCreator(User creator);

    Optional<Training> findByCode(String code);

}
