package com.ticketera.infrastructure.adapters.out.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String name;

    @NotBlank(message = "La categoría es obligatoria")
    private String category;

    @Future(message = "La fecha debe ser futura")
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate startDate;

    // TASK 1: Relación ManyToOne optimizada (FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venue_id", nullable = false)
    @ToString.Exclude
    private VenueEntity venue;
}