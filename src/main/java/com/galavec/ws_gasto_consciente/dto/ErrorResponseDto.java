package com.galavec.ws_gasto_consciente.dto;

import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase utilizada para transferencia de datos sobre errores en la respuesta de la solicitud.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
public class ErrorResponseDto {
    private String codError;
    private String message;
    private String details;
    private String recommendation;

    /**
     * Construye un nuevo ErrorResponseDto con el tipo de error y los detalles especificados.
     *
     * @param errorTypeEnum el tipo de error, que proporciona el código de error, el mensaje y la recomendación.
     * @param details       detalles adicionales sobre el error.
     * @author Héctor Galavec
     * @see ErrorTypeEnum
     * @since 1.0.0
     */
    public ErrorResponseDto(ErrorTypeEnum errorTypeEnum, String details) {
        this.codError = errorTypeEnum.getCode();
        this.message = errorTypeEnum.getMessage();
        this.details = details;
        this.recommendation = errorTypeEnum.getRecommendation();
    }
}
