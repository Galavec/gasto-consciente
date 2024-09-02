package com.galavec.ws_gasto_consciente.dto;

import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase utilizada para transferencia de datos sobre las respuestas erróneas de la solicitud.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@Schema(description = "Respuesta de error de la API")
public class ErrorResponseDto {
    @Schema(description = "Código de respuesta de error", example = "500")
    private String codResponse;

    @Schema(description = "Mensaje de error", example = "Error interno del servidor")
    private String message;

    @Schema(description = "Detalles adicionales sobre el error", example = "Se ha producido un error en la base de datos")
    private String details;

    @Schema(description = "Recomendaciones para solucionar el error", example = "Verificar la conexión a la base de datos")
    private String recommendation;

    /**
     * Construye un nuevo ErrorResponseDto con argumentos.
     *
     * @param errorTypeEnum el tipo de error, que proporciona el código de error, el mensaje y la recomendación.
     * @param details       detalles adicionales sobre el error.
     * @author Héctor Galavec
     * @see ErrorTypeEnum
     * @since 1.0.0
     */
    public ErrorResponseDto(ErrorTypeEnum errorTypeEnum, String details) {
        this.codResponse = errorTypeEnum.getCode();
        this.message = errorTypeEnum.getMessage();
        this.details = details;
        this.recommendation = errorTypeEnum.getRecommendation();
    }
}
