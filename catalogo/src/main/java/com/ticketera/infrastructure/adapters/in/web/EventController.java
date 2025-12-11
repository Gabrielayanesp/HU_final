package com.ticketera.infrastructure.adapters.in.web;

import com.ticketera.dominio.model.Event;
import com.ticketera.dominio.ports.in.CreateEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventUseCase;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return new ResponseEntity<>(createEventUseCase.createEvent(event), HttpStatus.CREATED);
    }

    // Uso: GET /events?city=Bogota
    // Uso: GET /events (Trae todos)
    @GetMapping
    public ResponseEntity<List<Event>> getEvents(@RequestParam(required = false) String city) {
        if (city != null && !city.isBlank()) {
            // Si viene el parametro city, usamos el filtro optimizado
            return ResponseEntity.ok(createEventUseCase.getEventsByCity(city));
        }
        // Si no viene, traemos todos
        return ResponseEntity.ok(createEventUseCase.getAllEvents());
    }
}


