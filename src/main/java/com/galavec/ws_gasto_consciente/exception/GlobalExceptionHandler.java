package com.galavec.ws_gasto_consciente.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.galavec.ws_gasto_consciente.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        log.error("Error en handleValidationExceptions: {}", errors);

        ErrorResponseDto errorResponseDto = new ErrorResponseDto("-1", "Tamaño o formato incorrecto de los valores que se envían en el request.", errors, "Revisar el valor del campo que se indica en \"details\".");

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ErrorResponseDto> handleUnknownPropertyExceptions(UnrecognizedPropertyException ex) {
        log.error("Error en handleUnknownPropertyExceptions: {}", ex.getMessage());

        ErrorResponseDto errorResponseDto = new ErrorResponseDto("-2", "Uno o varios campos del request tienen nombres incorrectos.", ex.getPropertyName(), "Revisar el nombre del campo que se indica en \"details\".");

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidLocalDateFormatException(InvalidDateFormatException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto("-3", "Error en el formato de fecha.", ex.getMessage(), "Por favor enviar la fecha en el formato correcto.");

        log.error("Error en handleInvalidLocalDateFormatException: {}", ex.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
