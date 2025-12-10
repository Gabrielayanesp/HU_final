package com.ticketera.controller;

import com.ticketera.dto.EventDTO;
import com.ticketera.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@Tag(name = "Eventos", description = "Gestión del catálogo de eventos")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    @Operation(summary = "Listar eventos", description = "Obtiene todos los eventos registrados")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar evento", description = "Obtiene un evento por su ID")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Manejo de 404
    }

    @PostMapping
    @Operation(summary = "Crear evento", description = "Crea un nuevo evento en el catálogo")
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO) {
        EventDTO createdEvent = eventService.createEvent(eventDTO);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar evento", description = "Actualiza la información de un evento existente")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @Valid @RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(id, eventDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar evento", description = "Elimina un evento del catálogo")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        if (eventService.deleteEvent(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}