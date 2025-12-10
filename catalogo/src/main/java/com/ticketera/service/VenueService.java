package com.ticketera.service;

import com.ticketera.dto.VenueDTO;
import com.ticketera.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<VenueDTO> getAllVenues() {
        return venueRepository.findAll();
    }

    public Optional<VenueDTO> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    public VenueDTO createVenue(VenueDTO venueDTO) {
        return venueRepository.save(venueDTO);
    }

    public Optional<VenueDTO> updateVenue(Long id, VenueDTO venueDetails) {
        return venueRepository.findById(id).map(existingVenue -> {
            existingVenue.setName(venueDetails.getName());
            existingVenue.setAddress(venueDetails.getAddress());
            existingVenue.setCapacity(venueDetails.getCapacity());
            return venueRepository.save(existingVenue);
        });
    }

    public boolean deleteVenue(Long id) {
        return venueRepository.deleteById(id);
    }
}