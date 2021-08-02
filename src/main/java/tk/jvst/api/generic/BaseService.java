package tk.jvst.api.generic;

import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<T extends BaseEntity> {

    private BaseRepository<T> repository;

    protected BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(Long id) {
        Optional<T> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return entity.get();
    }

    public List<T> saveAll(List<T> entities) {
        return entities.stream().map(this::save).collect(Collectors.toList());
    }

    public T save(T entity) {
        return repository.save(preProcess(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public T preProcess(T obj) {
        return obj;
    }
}
