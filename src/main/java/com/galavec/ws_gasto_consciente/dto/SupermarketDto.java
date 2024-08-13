package com.galavec.ws_gasto_consciente.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.galavec.ws_gasto_consciente.util.CustomLocalDateTimeDeserializer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Clase utilizada para transferir datos relacionados con los supermercados.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupermarketDto {
    @NotNull(message = "El nombre del supermercado no puede ser nulo.")
    @Size(min = 1, max = 255, message = "El nombre del supermercado debe tener entre 1 y 255 caracteres.")
    private String supermarketName;

    @Size(min = 0, max = 500, message = "La descripción para el supermercado debe tener entre 1 y 500 caracteres.")
    private String supermarketDescription;

    @NotNull(message = "El código del usuario de creación no puede ser nulo.")
    @Size(min = 1, max = 50, message = "El código del usuario de creación debe tener entre 1 y 50 caracteres.")
    private String userCreation;

    @NotNull(message = "La fecha de creación no puede ser nulo.")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dateCreation;

    @NotNull(message = "El estado del registro no puede ser nulo.")
    private String supermarketStatus;
}
