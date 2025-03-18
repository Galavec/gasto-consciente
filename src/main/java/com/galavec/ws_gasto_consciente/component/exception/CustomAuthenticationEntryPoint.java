package com.galavec.ws_gasto_consciente.component.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galavec.ws_gasto_consciente.dto.ErrorResponseDto;
import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

/**
 * Punto de entrada personalizado para manejar errores de autenticación.
 * <p>
 * Esta clase se encarga de manejar las excepciones de autenticación,
 * generando una respuesta de error en formato JSON y estableciendo el estado HTTP a 401 (Unauthorized).
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * Inicia el manejo de una excepción de autenticación.
     * <p>
     * Captura las excepciones AuthenticationException, genera una respuesta de error personalizada
     * en formato JSON y la envía al cliente, estableciendo el estado HTTP a 401 (Unauthorized).
     * </p>
     *
     * @param request       La solicitud HTTP que resultó en una AuthenticationException.
     * @param response      La respuesta HTTP en la que se escribirá el error.
     * @param authException La excepción lanzada cuando ocurre un error de autenticación.
     * @throws IOException Sí ocurre un error de entrada/salida al escribir la respuesta.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        ErrorResponseDto errorResponse = new ErrorResponseDto(ErrorTypeEnum.INCORRECT_AUTHENTICATION, authException.getMessage());

        response.setStatus(Integer.parseInt(ErrorTypeEnum.INCORRECT_AUTHENTICATION.getCode()));
        response.setContentType("application/json");

        response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
    }
}
