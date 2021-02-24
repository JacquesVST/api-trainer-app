package tk.jvst.api.services.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.repositories.session.SessionRepository;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
}
