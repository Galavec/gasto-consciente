package com.galavec.ws_gasto_consciente.dto;

import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import com.galavec.ws_gasto_consciente.enums.SuccessTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase utilizada para transferencia de datos sobre errores y respuestas exitosas de la solicitud.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
public class ResponseDto {
    private String codResponse;
    private String message;
    private String details;
    private String recommendation;

    /**
     * Construye un nuevo ResponseDto con el tipo de error y los detalles especificados.
     *
     * @param errorTypeEnum el tipo de error, que proporciona el código de error, el mensaje y la recomendación.
     * @param details       detalles adicionales sobre el error.
     * @author Héctor Galavec
     * @see ErrorTypeEnum
     * @since 1.0.0
     */
    public ResponseDto(ErrorTypeEnum errorTypeEnum, String details) {
        this.codResponse = errorTypeEnum.getCode();
        this.message = errorTypeEnum.getMessage();
        this.details = details;
        this.recommendation = errorTypeEnum.getRecommendation();
    }

    /**
     * Construye un nuevo ResponseDto con el tipo de respuesta exitosa.
     *
     * @param successTypeEnum el tipo de respuesta exitosa, que proporciona el código de respuesta exitosa y el mensaje.
     * @author Héctor Galavec
     * @see SuccessTypeEnum
     * @since 1.0.0
     */
    public ResponseDto(SuccessTypeEnum successTypeEnum, String details) {
        this.codResponse = successTypeEnum.getCode();
        this.message = successTypeEnum.getMessage();
        this.details = details;
    }
}
