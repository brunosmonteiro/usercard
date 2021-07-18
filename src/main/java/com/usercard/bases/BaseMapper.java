package com.usercard.bases;

import com.usercard.error.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static com.usercard.error.MessageConstants.MISSING_ENTITY;

public abstract class BaseMapper<Dto extends BaseDto, Entity extends BaseEntity> {
    @Autowired
    private EntityManager em;

    public abstract Dto toDto(Entity entity);

    public abstract Entity toEntity(Dto dto);

    public Long getId(Entity entity) {
        return entity.getId();
    }

    @Mapping(target = "id", ignore = true)
    public abstract Entity toEntity(Long id);

    @ObjectFactory
    @SneakyThrows
    public Entity findEntity(Dto dto, @TargetType Class<Entity> clazz) {
        Entity loaded = em.find(clazz, dto.getId());
        if (loaded == null) {
            return clazz.getDeclaredConstructor().newInstance();
        }
        return loaded;
    }

    @ObjectFactory
    public Entity findEntity(Long id, @TargetType Class<Entity> clazz) {
        Entity loaded = em.find(clazz, id);
        if (loaded == null) {
            throw new EntityNotFoundException(MISSING_ENTITY);
        }
        return loaded;
    }
}
