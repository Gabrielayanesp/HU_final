package com.ticketera.dominio.model;
import lombok.Data;

@Data
public class Venue {
    private Long id;
    private String name;
    private String city;
    private String address;
}