package com.ticketera.infrastructure.adapters.out.jpa.mapper;

import com.ticketera.dominio.model.Event;
import com.ticketera.infrastructure.adapters.out.jpa.entity.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

// AGREGAMOS 'uses = {VenueMapper.class}'
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {VenueMapper.class})
public interface EventMapper {

    EventEntity toEntity(Event event);
    Event toDomain(EventEntity eventEntity);
}