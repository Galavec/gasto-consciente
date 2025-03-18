package com.galavec.ws_gasto_consciente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Clase utilizada para transferencia de datos sobre la respuesta de generación de token.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public class JwtResponseDto {

    @Schema(description = "Código de respuesta para la solicitud", example = "200")
    private String codResponse;

    @Schema(description = "Contiene el token", example = "eyJhbG")
    private String token;
}
