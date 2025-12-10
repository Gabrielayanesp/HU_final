package com.ticketera.controller;

import com.ticketera.dto.VenueDTO;
import com.ticketera.service.VenueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
@Tag(name = "Venues", description = "Gestión del catálogo de lugares (Venues)")
public class VenueController {

    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    @Operation(summary = "Listar venues", description = "Obtiene todos los lugares registrados")
    public ResponseEntity<List<VenueDTO>> getAllVenues() {
        return ResponseEntity.ok(venueService.getAllVenues());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar venue", description = "Obtiene un lugar por su ID")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable Long id) {
        return venueService.getVenueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear venue", description = "Crea un nuevo lugar en el catálogo")
    public ResponseEntity<VenueDTO> createVenue(@Valid @RequestBody VenueDTO venueDTO) {
        VenueDTO createdVenue = venueService.createVenue(venueDTO);
        return new ResponseEntity<>(createdVenue, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar venue", description = "Actualiza la información de un lugar existente")
    public ResponseEntity<VenueDTO> updateVenue(@PathVariable Long id, @Valid @RequestBody VenueDTO venueDTO) {
        return venueService.updateVenue(id, venueDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar venue", description = "Elimina un lugar del catálogo")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        if (venueService.deleteVenue(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}