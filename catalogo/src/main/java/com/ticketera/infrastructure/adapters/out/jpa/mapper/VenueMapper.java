package com.ticketera.infrastructure.adapters.out.jpa.mapper;

import com.ticketera.dominio.model.Venue;
import com.ticketera.infrastructure.adapters.out.jpa.entity.VenueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VenueMapper {
    VenueEntity toEntity(Venue venue);
    Venue toDomain(VenueEntity venueEntity);
}