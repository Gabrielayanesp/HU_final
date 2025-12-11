package com.ticketera.dominio.ports.out;
import com.ticketera.dominio.model.Event;

public interface EventRepositoryPort {
    Event save(Event event);
    boolean existsByName(String name);
}