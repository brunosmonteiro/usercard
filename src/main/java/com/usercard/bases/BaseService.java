package com.usercard.bases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService<Entity extends BaseEntity> {
    @Autowired
    protected BaseRepository<Entity> repository;

    public Long create(Entity entity) {
        return repository.save(entity).getId();
    }

    public Entity update(Entity entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Entity get(Long id) {
        return repository.findById(id).orElse(null);
    }
}
