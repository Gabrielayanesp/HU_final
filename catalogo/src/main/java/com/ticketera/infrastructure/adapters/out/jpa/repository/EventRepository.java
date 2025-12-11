package com.ticketera.infrastructure.adapters.out.jpa.repository;

import com.ticketera.infrastructure.adapters.out.jpa.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    boolean existsByName(String name);
} // <--- Solo debe haber UNA llave de cierre aquí. ¡Ni una más!