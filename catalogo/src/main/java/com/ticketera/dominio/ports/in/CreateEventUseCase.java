package com.ticketera.dominio.ports.in;

import com.ticketera.dominio.model.Event;
import java.util.List;

public interface CreateEventUseCase {
    Event createEvent(Event event);

    List<Event> getAllEvents();
    List<Event> getEventsByCity(String city);
}