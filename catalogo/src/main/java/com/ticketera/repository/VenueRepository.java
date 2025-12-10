package com.ticketera.repository;

import com.ticketera.dto.VenueDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VenueRepository {

    // Simulación de base de datos en memoria para Venues
    private final List<VenueDTO> venues = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<VenueDTO> findAll() {
        return new ArrayList<>(venues);
    }

    public Optional<VenueDTO> findById(Long id) {
        return venues.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    public VenueDTO save(VenueDTO venue) {
        if (venue.getId() == null) {
            venue.setId(idGenerator.getAndIncrement());
            venues.add(venue);
        } else {
            deleteById(venue.getId());
            venues.add(venue);
        }
        return venue;
    }

    public boolean deleteById(Long id) {
        return venues.removeIf(v -> v.getId().equals(id));
    }
}