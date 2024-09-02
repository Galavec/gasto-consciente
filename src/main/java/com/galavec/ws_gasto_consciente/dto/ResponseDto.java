package com.galavec.ws_gasto_consciente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Respuesta de la API que incluye código de respuesta, mensaje, detalles y recomendación")
public class ResponseDto {
    @Schema(description = "Código de respuesta", example = "200")
    private String codResponse;

    @Schema(description = "Mensaje de la respuesta", example = "Operación exitosa")
    private String message;

    @Schema(description = "Detalles adicionales", example = "ID del nuevo supermercado: 123")
    private String details;

    @Schema(description = "Recomendación o sugerencia", example = "Verificar los datos ingresados")
    private String recommendation;

    /**
     * Construye un nuevo ResponseDto con el tipo de error y los detalles especificados.
     *
     * @param errorResponseDto contiene el código de error, mensaje, detalles adicionales y la recomendación.
     * @author Héctor Galavec
     * @see ErrorResponseDto
     * @since 1.0.0
     */
    public ResponseDto(ErrorResponseDto errorResponseDto) {
        this.codResponse = errorResponseDto.getCodResponse();
        this.message = errorResponseDto.getMessage();
        this.details = errorResponseDto.getDetails();
        this.recommendation = errorResponseDto.getRecommendation();
    }

    /**
     * Construye un nuevo ResponseDto con el tipo de respuesta exitosa.
     *
     * @param successResponseDto contiene el código de respuesta exitosa, mensaje y la recomendación.
     * @author Héctor Galavec
     * @see SuccessResponseDto
     * @since 1.0.0
     */
    public ResponseDto(SuccessResponseDto successResponseDto) {
        this.codResponse = successResponseDto.getCodResponse();
        this.message = successResponseDto.getMessage();
        this.details = successResponseDto.getDetails();
    }
}
