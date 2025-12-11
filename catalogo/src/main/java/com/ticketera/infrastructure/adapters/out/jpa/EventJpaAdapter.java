package com.ticketera.infrastructure.adapters.out.jpa;

import com.ticketera.dominio.model.Event;
import com.ticketera.dominio.ports.out.EventRepositoryPort;
import com.ticketera.infrastructure.adapters.out.jpa.entity.EventEntity;
import com.ticketera.infrastructure.adapters.out.jpa.mapper.EventMapper;
import com.ticketera.infrastructure.adapters.out.jpa.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventJpaAdapter implements EventRepositoryPort {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public Event save(Event event) {
        // 1. Convertir Dominio -> Entidad
        EventEntity entity = eventMapper.toEntity(event);

        // 2. Guardar en H2 usando JPA
        EventEntity savedEntity = eventRepository.save(entity);

        // 3. Convertir Entidad guardada -> Dominio
        return eventMapper.toDomain(savedEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return eventRepository.existsByName(name);
    }
}