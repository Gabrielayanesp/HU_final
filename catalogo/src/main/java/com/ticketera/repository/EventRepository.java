package com.ticketera.repository;

import com.ticketera.dto.EventDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EventRepository {
    // Data base simulation
    private final List<EventDTO> events = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<EventDTO> findAll() {
        return new ArrayList<>(events);
    }

    public Optional<EventDTO> findById(Long id) {
        return events.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public EventDTO save(EventDTO event) {
        if (event.getId() == null) {
            event.setId(idGenerator.getAndIncrement());
            events.add(event);
        } else {
            // If it exists, we update it (delete and insert or replace)
            deleteById(event.getId());
            events.add(event);
        }
        return event;
    }

    public boolean deleteById(Long id) {
        return events.removeIf(e -> e.getId().equals(id));
    }
}