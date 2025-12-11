package com.ticketera.dominio.ports.in;
import com.ticketera.dominio.model.Event;

public interface CreateEventUseCase {
    Event createEvent(Event event);
}