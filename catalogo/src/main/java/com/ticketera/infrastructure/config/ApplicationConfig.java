package com.ticketera.infrastructure.config;

import com.ticketera.aplicacion.usecase.EventUseCaseImpl;
import com.ticketera.dominio.ports.in.CreateEventUseCase;
import com.ticketera.dominio.ports.out.EventRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateEventUseCase createEventUseCase(EventRepositoryPort eventRepositoryPort) {
        return new EventUseCaseImpl(eventRepositoryPort);
    }
}