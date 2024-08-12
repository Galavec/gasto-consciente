package com.galavec.ws_gasto_consciente.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.galavec.ws_gasto_consciente.dto.ErrorResponseDto;
import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
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

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.INCORRECT_SIZE, errors);

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ErrorResponseDto> handleUnknownPropertyExceptions(UnrecognizedPropertyException ex) {
        log.error("Error en handleUnknownPropertyExceptions: {}", ex.getMessage());

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.UNKNOWN_PROPERTY, ex.getPropertyName());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidLocalDateFormatException(InvalidDateFormatException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.INVALID_DATE_FORMAT, ex.getMessage());

        log.error("Error en handleInvalidLocalDateFormatException: {}", ex.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
