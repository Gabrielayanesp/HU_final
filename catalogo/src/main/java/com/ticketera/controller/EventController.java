package com.ticketera.controller;

import com.ticketera.entity.EventEntity;
import com.ticketera.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Task 3: Endpoint con paginación y filtros
    // Ejemplo de uso: GET /events?page=0&size=5&sort=name,asc&category=Musica
    @GetMapping
    public ResponseEntity<Page<EventEntity>> getAllEvents(
            @PageableDefault(size = 10, sort = "startDate") Pageable pageable,
            @RequestParam(required = false) String category) {

        return ResponseEntity.ok(eventService.getAllEvents(pageable, category));
    }

    // Task 2: Creación con @Valid
    @PostMapping
    public ResponseEntity<EventEntity> createEvent(@Valid @RequestBody EventEntity event) {
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventEntity> getEvent(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}