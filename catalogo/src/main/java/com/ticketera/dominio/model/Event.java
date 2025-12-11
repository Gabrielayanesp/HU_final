package com.ticketera.dominio.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Event {
    private Long id;
    private String name;
    private String category;      // <--- Asegúrate de tener esto
    private LocalDate startDate;  // <--- Y esto
    private Venue venue;          // <--- Y esto (NO venueId)
}