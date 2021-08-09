package tk.jvst.api.tag;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.jvst.api.tag.dto.TagRequestDTO;

import java.util.List;

@Api(value = "Tag", tags = {"Tag"})
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService service;

    @GetMapping
    public ResponseEntity<List<Tag>> findAll() {
        return ResponseEntity.ok(service.findAllSorted());
    }

    @PostMapping
    public ResponseEntity<Tag> persistTag(@RequestBody TagRequestDTO tagRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.persistTag(tagRequestDTO.toModel()));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTag(@RequestParam Long tagId) {
        service.deleteById(tagId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
