package com.ticketera.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "venues")
public class VenueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String address;
}