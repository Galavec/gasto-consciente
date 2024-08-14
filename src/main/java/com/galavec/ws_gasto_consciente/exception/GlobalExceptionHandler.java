package com.galavec.ws_gasto_consciente.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.galavec.ws_gasto_consciente.dto.ResponseDto;
import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * <p>Captura las excepciones {@code MethodArgumentNotValidException} que ocurren cuando
     * los argumentos de una solicitud no son válidos. Extrae los mensajes de error, los registra y crea
     * una respuesta de error con un código de error y detalles específicos.</p>
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

        ResponseDto responseDto = new ResponseDto(ErrorTypeEnum.INCORRECT_SIZE, errors);

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Función que recibe una excepción debido a una propiedad(nombre de campo) desconocida en la solicitud.
     * <p>Captura las excepciones {@code UnrecognizedPropertyException} que ocurren cuando
     * se encuentra una propiedad desconocida en la solicitud. Registra el mensaje de error, crea una
     * una respuesta de error con un código de error y detalles específicos.</p>
     *
     * @param ex la excepción {@code UnrecognizedPropertyException} que contiene los detalles del error.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ResponseDto> handleUnknownPropertyExceptions(UnrecognizedPropertyException ex) {
        log.error("Error en handleUnknownPropertyExceptions: {}", ex.getMessage());

        ResponseDto responseDto = new ResponseDto(ErrorTypeEnum.UNKNOWN_PROPERTY, ex.getPropertyName());

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * Función que recibe una excepción debido a un formato incorrecto de fecha y hora en la solicitud.
     * <p>Captura las excepciones {@code InvalidDateFormatException} que ocurren cuando
     * se encuentra un formato de fecha inválido en el request. Crea una respuesta de error con un
     * código de error y detalles específicos.</p>
     *
     * @param ex la excepción {@code InvalidDateFormatException} que contiene los detalles del error.
     * @return una respuesta HTTP con un objeto {@code ResponseDto} y el estado {@code BAD_REQUEST}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ResponseDto> handleInvalidLocalDateFormatException(InvalidDateFormatException ex) {
        ResponseDto responseDto = new ResponseDto(ErrorTypeEnum.INVALID_DATE_FORMAT, ex.getMessage());

        log.error("Error en handleInvalidLocalDateFormatException: {}", ex.getMessage());

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
