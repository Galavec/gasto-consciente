package com.galavec.ws_gasto_consciente.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración para las validaciones de objetos Jackson.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class JacksonConfig {

    /**
     * Nos ayuda a validar cada nombre de campo en una solicitud.
     *
     * @return un objeto mapeado.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper;
    }
}
