package tk.jvst.api.session;

import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;

@Service
public class SessionService extends BaseService<Session> {

    public SessionService(BaseRepository<Session> repository) {
        super(repository);
    }

}
