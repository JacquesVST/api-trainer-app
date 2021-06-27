package tk.jvst.api.user;

import tk.jvst.api.generic.BaseRepository;

import java.util.List;

public interface UserLibraryRepository extends BaseRepository<UserLibrary> {

    List<UserLibrary> findAllByEndUser(User endUser);
}
