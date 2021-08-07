package tk.jvst.api.session;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.library.UserLibrary;

import java.util.List;

public interface SessionRepository extends BaseRepository<Session> {

    List<Session> findByUserLibraryIn(List<UserLibrary> userLibraries);
}
