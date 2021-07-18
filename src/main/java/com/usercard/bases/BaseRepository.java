package com.usercard.bases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseRepository<Entity> extends JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity> {
}
