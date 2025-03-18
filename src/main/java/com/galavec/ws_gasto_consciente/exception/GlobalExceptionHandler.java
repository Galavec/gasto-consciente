package com.galavec.ws_gasto_consciente.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.galavec.ws_gasto_consciente.dto.ErrorResponseDto;
import com.galavec.ws_gasto_consciente.dto.ResponseDto;
import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

/**
 * Clase para controlar las excepciones globales.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Función que recibe una excepción debido a un tamaño incorrecto de los valores que se reciben en la solicitud.
     * <p>
     * Captura las excepciones {@code MethodArgumentNotValidException} que ocurren cuando
     * los argumentos de una solicitud no son válidos. Extrae los mensajes de error, los registra y crea
     * una respuesta de error con un código de error y detalles específicos.
     * </p>
     *
     * @param ex la excepción {@code MethodArgumentNotValidException} que contiene los detalles de los errores de validación.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        log.error("Error en handleValidationExceptions: {}", errors);

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.INCORRECT_SIZE, errors);

        ResponseDto responseDto = new ResponseDto(errorResponseDto);

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Función que recibe una excepción debido a una propiedad(nombre de campo) desconocida en la solicitud.
     * <p>
     * Captura las excepciones {@code UnrecognizedPropertyException} que ocurren cuando
     * se encuentra una propiedad desconocida en la solicitud. Registra el mensaje de error, crea
     * una respuesta de error con un código de error y detalles específicos.
     * </p>
     *
     * @param ex la excepción {@code UnrecognizedPropertyException} que contiene los detalles del error.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ResponseDto> handleUnknownPropertyExceptions(UnrecognizedPropertyException ex) {
        log.error("Error en handleUnknownPropertyExceptions: {}", ex.getMessage());

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.UNKNOWN_PROPERTY, ex.getPropertyName());

        ResponseDto responseDto = new ResponseDto(errorResponseDto);

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Función que recibe una excepción debido a un formato incorrecto de fecha y hora en la solicitud.
     * <p>
     * Captura las excepciones {@code InvalidDateFormatException} que ocurren cuando
     * se encuentra un formato de fecha inválido en el request. Crea una respuesta de error con un
     * código de error y detalles específicos.
     * </p>
     *
     * @param ex la excepción {@code InvalidDateFormatException} que contiene los detalles del error.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ResponseDto> handleInvalidLocalDateFormatException(InvalidDateFormatException ex) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.INVALID_DATE_FORMAT, ex.getMessage());

        ResponseDto responseDto = new ResponseDto(errorResponseDto);

        log.error("Error en handleInvalidLocalDateFormatException: {}", ex.getMessage());

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Función que recibe una excepción debido a un acceso no autorizado por falta de permisos.
     * <p>
     * Captura las excepciones {@code AccessDeniedException} que ocurren cuando
     * no se obtiene acceso al recurso correspondiente. Crea una respuesta de error con un
     * código de error y detalles específicos.
     * </p>
     *
     * @param ex la excepción {@code AccessDeniedException} que contiene los detalles del error.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResponseDto> handleAccessDenied(AccessDeniedException ex) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.UNAUTHORIZED_ACCESS, ex.getMessage());

        ResponseDto responseDto = new ResponseDto(errorResponseDto);

        log.error("Error en handleAccessDenied: {}", ex.getMessage());

        return new ResponseEntity<>(responseDto, HttpStatus.FORBIDDEN);
    }

    /**
     * Función que recibe una excepción debido a credenciales no encontradas.
     * <p>
     * Captura las excepciones relacionadas con credenciales de autenticación no encontradas,
     * genera una respuesta de error personalizada y la registra en los logs.
     * </p>
     *
     * @param ex la excepción {@code AuthenticationException} que contiene los detalles del error.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<ResponseDto> handleUnauthorizedException(AuthenticationException ex) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.INCORRECT_AUTHENTICATION, ex.getMessage());

        ResponseDto responseDto = new ResponseDto(errorResponseDto);

        log.error("Error en handleUnauthorizedException: {}", ex.getMessage());

        return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Función que recibe una excepción debido a credenciales incorrectas.
     * <p>
     * Captura las excepciones relacionadas con errores de autenticación,
     * genera una respuesta de error personalizada y la registra en los logs.
     * </p>
     *
     * @param ex la excepción {@code AuthenticationException} que contiene los detalles del error.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ResponseDto> handleAuthenticationException(AuthenticationException ex) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.INCORRECT_AUTHENTICATION, ex.getMessage());

        ResponseDto responseDto = new ResponseDto(errorResponseDto);

        log.error("Error en handleAuthenticationException: {}", ex.getMessage());

        return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);
    }
}
