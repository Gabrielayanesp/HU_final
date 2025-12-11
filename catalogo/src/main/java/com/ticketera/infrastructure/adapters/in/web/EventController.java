package com.ticketera.infrastructure.adapters.in.web;

import com.ticketera.dominio.model.Event;
import com.ticketera.dominio.ports.in.CreateEventUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventUseCase;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = createEventUseCase.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }


}