package com.galavec.ws_gasto_consciente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Datos del supermercado")
public class SupermarketDto {
    @Schema(description = "Nombre del supermercado", example = "ABC", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nombre del supermercado no puede estar vacío.")
    @Size(min = 1, max = 255, message = "El nombre del supermercado debe tener entre 1 y 255 caracteres.")
    private String supermarketName;

    @Schema(description = "Una descripción del supermercado", example = "ABC es una cadena de supermercados de...", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Size(min = 0, max = 500, message = "La descripción para el supermercado debe tener entre 1 y 500 caracteres.")
    private String supermarketDescription;

    @Schema(description = "Código del usuario que creó el registro", example = "admin", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El código del usuario de creación no puede estar vacío.")
    @Size(min = 1, max = 50, message = "El código del usuario de creación debe tener entre 1 y 50 caracteres.")
    private String userCreation;

    @Schema(description = "Estado del registro, \"A\" (activo) o \"I\" (inactivo)", example = "A", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El estado del registro no puede estar vacío.")
    @Size(min = 1, max = 1, message = "Estado del registro debe ser sólo una letra: \"A\" (activo) o \"I\" (inactivo)")
    private String supermarketStatus;
}
