package tk.jvst.api.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.jvst.api.generic.BaseRepository;
import tk.jvst.api.generic.BaseService;
import tk.jvst.api.util.FileUtilities;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FileService extends BaseService<File> {

    public FileService(BaseRepository<File> repository) {
        super(repository);
    }

    @Autowired
    private FileRepository fileRepository;

    public List<File> findAllByType(Set<String> type) {
        return fileRepository.findByTypeIn(type);
    }

    public List<File> uploadFiles(MultipartFile[] mpFiles) {
        List<File> files = Arrays.stream(mpFiles).map(FileUtilities::fromMultipartFile).collect(Collectors.toList());
        return saveAll(files);
    }

}
