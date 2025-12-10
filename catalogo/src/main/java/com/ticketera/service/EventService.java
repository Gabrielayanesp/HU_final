package com.ticketera.service;

import com.ticketera.dto.EventDTO;
import com.ticketera.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<EventDTO> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        return eventRepository.save(eventDTO);
    }

    public Optional<EventDTO> updateEvent(Long id, EventDTO eventDetails) {
        return eventRepository.findById(id).map(existingEvent -> {
            existingEvent.setName(eventDetails.getName());
            existingEvent.setDescription(eventDetails.getDescription());
            existingEvent.setVenueId(eventDetails.getVenueId());
            return eventRepository.save(existingEvent);
        });
    }

    public boolean deleteEvent(Long id) {
        return eventRepository.deleteById(id);
    }
}