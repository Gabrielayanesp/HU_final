package com.ticketera.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long id;

    @NotBlank(message = "The event name cannot be empty")
    private String name;

    private String description;
    // We link by ID to keep it simple at this stage
    private Long venueId;
}