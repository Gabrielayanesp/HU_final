package com.ticketera.infrastructure.adapters.out.jpa;

import com.ticketera.dominio.model.Event;
import com.ticketera.dominio.ports.out.EventRepositoryPort;
import com.ticketera.infrastructure.adapters.out.jpa.entity.EventEntity;
import com.ticketera.infrastructure.adapters.out.jpa.mapper.EventMapper;
import com.ticketera.infrastructure.adapters.out.jpa.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventJpaAdapter implements EventRepositoryPort {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public Event save(Event event) {
        EventEntity entity = eventMapper.toEntity(event);
        EventEntity savedEntity = eventRepository.save(entity);
        return eventMapper.toDomain(savedEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return eventRepository.existsByName(name);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAllWithVenue().stream() // Usamos el método JOIN FETCH
                .map(eventMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findByCity(String city) {
        return eventRepository.findByCity(city).stream()
                .map(eventMapper::toDomain)
                .collect(Collectors.toList());
    }
}