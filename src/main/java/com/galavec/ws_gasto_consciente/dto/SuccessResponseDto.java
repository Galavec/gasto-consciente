package com.galavec.ws_gasto_consciente.dto;

import com.galavec.ws_gasto_consciente.enums.SuccessTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase utilizada para transferencia de datos sobre las respuestas exitosas de la solicitud.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@Schema(description = "Respuesta de éxito de la API")
public class SuccessResponseDto {
    @Schema(description = "Código de respuesta de éxito", example = "200")
    private String codResponse;

    @Schema(description = "Mensaje de éxito", example = "Operación exitosa")
    private String message;

    @Schema(description = "Detalles adicionales de la respuesta exitosa", example = "ID del nuevo supermercado: 123")
    private String details;

    /**
     * Construye un nuevo SuccessResponseDto con argumentos.
     *
     * @param successTypeEnum el tipo de respuesta exitosa, que proporciona el código de respuesta exitosa y el mensaje.
     * @author Héctor Galavec
     * @see SuccessTypeEnum
     * @since 1.0.0
     */
    public SuccessResponseDto(SuccessTypeEnum successTypeEnum, String details) {
        this.codResponse = successTypeEnum.getCode();
        this.message = successTypeEnum.getMessage();
        this.details = details;
    }
}
