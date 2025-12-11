package com.ticketera.infrastructure.adapters.out.jpa.mapper;

import com.ticketera.dominio.model.Venue;
import com.ticketera.infrastructure.adapters.out.jpa.entity.VenueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping; // Importar esto
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VenueMapper {

    @Mapping(target = "events", ignore = true)
    VenueEntity toEntity(Venue venue);

    Venue toDomain(VenueEntity venueEntity);
}