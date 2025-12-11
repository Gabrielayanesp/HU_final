package com.ticketera.aplicacion.usecase;

import com.ticketera.dominio.model.Event;
import com.ticketera.dominio.ports.in.CreateEventUseCase;
import com.ticketera.dominio.ports.out.EventRepositoryPort;

public class EventUseCaseImpl implements CreateEventUseCase {

    private final EventRepositoryPort eventRepositoryPort;

    // Inyeccion por constructor (Puro Java, sin @Autowired)
    public EventUseCaseImpl(EventRepositoryPort eventRepositoryPort) {
        this.eventRepositoryPort = eventRepositoryPort;
    }

    @Override
    public Event createEvent(Event event) {
        // Validación de negocio: Verificar duplicados
        if (eventRepositoryPort.existsByName(event.getName())) {
            throw new IllegalArgumentException("Ya existe un evento con el nombre: " + event.getName());
        }
        return eventRepositoryPort.save(event);
    }
}