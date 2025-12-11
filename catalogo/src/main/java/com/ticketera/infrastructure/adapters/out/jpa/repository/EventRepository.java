package com.ticketera.infrastructure.adapters.out.jpa.repository;

import com.ticketera.infrastructure.adapters.out.jpa.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Importante
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    boolean existsByName(String name);

    @Query("SELECT e FROM EventEntity e JOIN FETCH e.venue")
    List<EventEntity> findAllWithVenue();

    @Query("SELECT e FROM EventEntity e JOIN FETCH e.venue v WHERE v.city = :city")
    List<EventEntity> findByCity(String city);
}