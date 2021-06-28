package tk.jvst.api.file;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.jvst.api.util.literals.FileTypes;

import java.util.List;

@Api(value = "File", tags = {"File"})
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService service;

    @GetMapping()
    public ResponseEntity<File> findAllImages(@RequestParam Long fileId) {
        return ResponseEntity.ok().body(service.findById(fileId));
    }

    @GetMapping("/images")
    public ResponseEntity<List<File>> findAllImages() {
        return ResponseEntity.ok().body(service.findAllByType(FileTypes.IMAGES));
    }

    @GetMapping("/videos")
    public ResponseEntity<List<File>> findAllVideos() {
        return ResponseEntity.ok().body(service.findAllByType(FileTypes.VIDEOS));
    }

    @PostMapping("/upload")
    public ResponseEntity<File> persistFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(service.save(File.fromMultipartFile(file)));
    }

    @PostMapping("/uploads")
    public ResponseEntity<List<File>> persistFile(@RequestParam("files") MultipartFile[] files) {
        return ResponseEntity.ok(service.uploadFiles(files));
    }
}
