package com.ticketera.dominio.ports.out;

import com.ticketera.dominio.model.Event;
import java.util.List;

public interface EventRepositoryPort {
    Event save(Event event);
    boolean existsByName(String name);

    List<Event> findAll();
    List<Event> findByCity(String city);
}