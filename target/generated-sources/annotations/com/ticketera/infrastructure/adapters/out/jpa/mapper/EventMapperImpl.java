package com.ticketera.infrastructure.adapters.out.jpa.mapper;

import com.ticketera.dominio.model.Event;
import com.ticketera.infrastructure.adapters.out.jpa.entity.EventEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T21:39:42-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (BellSoft)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Autowired
    private VenueMapper venueMapper;

    @Override
    public EventEntity toEntity(Event event) {
        if ( event == null ) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId( event.getId() );
        eventEntity.setName( event.getName() );
        eventEntity.setCategory( event.getCategory() );
        eventEntity.setStartDate( event.getStartDate() );
        eventEntity.setVenue( venueMapper.toEntity( event.getVenue() ) );

        return eventEntity;
    }

    @Override
    public Event toDomain(EventEntity eventEntity) {
        if ( eventEntity == null ) {
            return null;
        }

        Event event = new Event();

        event.setId( eventEntity.getId() );
        event.setName( eventEntity.getName() );
        event.setCategory( eventEntity.getCategory() );
        event.setStartDate( eventEntity.getStartDate() );
        event.setVenue( venueMapper.toDomain( eventEntity.getVenue() ) );

        return event;
    }
}
