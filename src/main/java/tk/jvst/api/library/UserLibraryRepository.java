package tk.jvst.api.library;

import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.library.UserLibrary;
import tk.jvst.api.user.User;

import java.util.List;

public interface UserLibraryRepository extends BaseRepository<UserLibrary> {

    List<UserLibrary> findAllByEndUser(User endUser);
}
