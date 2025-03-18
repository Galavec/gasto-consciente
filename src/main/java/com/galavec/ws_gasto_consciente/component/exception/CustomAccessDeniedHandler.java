package com.galavec.ws_gasto_consciente.component.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galavec.ws_gasto_consciente.dto.ErrorResponseDto;
import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Manejado personalizado para accesos denegados.
 * <p>
 * Esta clase maneja las excepciones de tipo AccessDeniedException lanzadas cuando un usuario intenta acceder a un recurso para el que no tiene permisos.
 * Genera una respuesta de error JSON y registra el evento.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * Manejo de las excepciones de acceso denegado.
     * <p>
     * Captura las excepciones AccessDeniedException, genera una respuesta de error personalizada
     * en formato JSON y la envía al cliente, registrando el evento en los logs.
     * </p>
     *
     * @param request               La solicitud HTTP que resultó en una AccessDeniedException.
     * @param response              La respuesta HTTP en la que se escribirá el error.
     * @param accessDeniedException La excepción lanzada cuando se deniega el acceso.
     * @throws IOException Sí ocurre un error de entrada/salida al escribir la respuesta.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ErrorResponseDto errorResponse = new ErrorResponseDto(ErrorTypeEnum.UNAUTHORIZED_ACCESS, accessDeniedException.getMessage());

        response.setStatus(Integer.parseInt(ErrorTypeEnum.UNAUTHORIZED_ACCESS.getCode()));
        response.setContentType("application/json");

        response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
    }
}