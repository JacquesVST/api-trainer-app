package tk.jvst.api.controllers.session;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.jvst.api.models.session.Session;
import tk.jvst.api.services.session.SessionService;

@Api(value = "Session", tags = {"Session"})
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public Session newSession() {
        return new Session();
    }
}
