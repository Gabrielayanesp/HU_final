package com.ticketera.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDTO {
    private Long id;

    @NotBlank(message = "The venue name cannot be empty")
    private String name;

    private String address;
    private Integer capacity;
}