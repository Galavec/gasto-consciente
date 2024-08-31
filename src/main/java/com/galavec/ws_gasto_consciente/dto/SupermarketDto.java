package com.galavec.ws_gasto_consciente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotBlank(message = "El nombre del supermercado no puede estar vacío.")
    @Size(min = 1, max = 255, message = "El nombre del supermercado debe tener entre 1 y 255 caracteres.")
    private String supermarketName;

    @Size(min = 0, max = 500, message = "La descripción para el supermercado debe tener entre 1 y 500 caracteres.")
    private String supermarketDescription;

    @NotBlank(message = "El código del usuario de creación no puede estar vacío.")
    @Size(min = 1, max = 50, message = "El código del usuario de creación debe tener entre 1 y 50 caracteres.")
    private String userCreation;

    @NotBlank(message = "El estado del registro no puede estar vacío.")
    private String supermarketStatus;
}
