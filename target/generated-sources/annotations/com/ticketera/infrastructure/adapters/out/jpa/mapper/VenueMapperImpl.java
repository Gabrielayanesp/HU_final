package com.ticketera.infrastructure.adapters.out.jpa.mapper;

import com.ticketera.dominio.model.Venue;
import com.ticketera.infrastructure.adapters.out.jpa.entity.VenueEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T21:39:42-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (BellSoft)"
)
@Component
public class VenueMapperImpl implements VenueMapper {

    @Override
    public VenueEntity toEntity(Venue venue) {
        if ( venue == null ) {
            return null;
        }

        VenueEntity venueEntity = new VenueEntity();

        venueEntity.setId( venue.getId() );
        venueEntity.setName( venue.getName() );
        venueEntity.setCity( venue.getCity() );
        venueEntity.setAddress( venue.getAddress() );

        return venueEntity;
    }

    @Override
    public Venue toDomain(VenueEntity venueEntity) {
        if ( venueEntity == null ) {
            return null;
        }

        Venue venue = new Venue();

        venue.setId( venueEntity.getId() );
        venue.setName( venueEntity.getName() );
        venue.setCity( venueEntity.getCity() );
        venue.setAddress( venueEntity.getAddress() );

        return venue;
    }
}
