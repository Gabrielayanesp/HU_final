package com.ticketera.aplicacion.usecase;

import com.ticketera.dominio.model.Event;
import com.ticketera.dominio.ports.in.CreateEventUseCase;
import com.ticketera.dominio.ports.out.EventRepositoryPort;
import java.util.List;

public class EventUseCaseImpl implements CreateEventUseCase {

    private final EventRepositoryPort eventRepositoryPort;

    public EventUseCaseImpl(EventRepositoryPort eventRepositoryPort) {
        this.eventRepositoryPort = eventRepositoryPort;
    }

    @Override
    public Event createEvent(Event event) {
        if (eventRepositoryPort.existsByName(event.getName())) {
            throw new IllegalArgumentException("Ya existe un evento con el nombre: " + event.getName());
        }
        return eventRepositoryPort.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepositoryPort.findAll();
    }

    @Override
    public List<Event> getEventsByCity(String city) {
        return eventRepositoryPort.findByCity(city);
    }
}