package tk.jvst.api.file;

import tk.jvst.api.generic.BaseRepository;

import java.util.List;
import java.util.Set;

public interface FileRepository extends BaseRepository<File> {

    List<File> findByTypeIn(Set<String> types);
}
