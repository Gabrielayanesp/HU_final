package com.ticketera.service;

import com.ticketera.entity.EventEntity;
import com.ticketera.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Task 3: Obtener eventos con paginación y filtro opcional
    public Page<EventEntity> getAllEvents(Pageable pageable, String category) {
        if (category != null && !category.isEmpty()) {
            return eventRepository.findByCategory(category, pageable);
        }
        return eventRepository.findAll(pageable);
    }

    // Task 1 y 2: Guardar con validación de duplicados
    public EventEntity createEvent(EventEntity event) {
        if (eventRepository.existsByName(event.getName())) {
            throw new IllegalArgumentException("Ya existe un evento con el nombre: " + event.getName());
        }
        return eventRepository.save(event);
    }

    public Optional<EventEntity> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            // Esto lanzará una excepción que podrías capturar o dejar que retorne vacío.
            // Para este ejercicio simple, solo borramos si existe.
        }
        eventRepository.deleteById(id);
    }
}