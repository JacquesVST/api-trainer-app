package tk.jvst.api.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;

@Service
public class UserLibraryService extends BaseService<UserLibrary> {

    public UserLibraryService(BaseRepository<UserLibrary> repository) {
        super(repository);
    }

    @Autowired
    private UserLibraryRepository userLibraryRepository;
}
