package com.galavec.ws_gasto_consciente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase utilizada para transferencia de datos sobre solicitudes para Login.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@Schema(description = "Solicitud para Login")
public class LoginRequestDto {

    @Schema(description = "Nombre de usuario", example = "user_1")
    private String username;

    @Schema(description = "Clave del usuario", example = "Cl@veUsu@ri0")
    private String password;
}
