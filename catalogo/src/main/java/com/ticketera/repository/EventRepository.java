package com.ticketera.repository;

import com.ticketera.entity.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    // Metodo para validar duplicados (Task 2)
    boolean existsByName(String name);

    // Metodo para filtros opcionales (Task 3)
    // Busca por categoría si se envía el parámetro
    Page<EventEntity> findByCategory(String category, Pageable pageable);
}