package com.galavec.ws_gasto_consciente.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorTypeEnum {
    INCORRECT_SIZE("-1", "Tamaño incorrecto de los valores que se envían en el request.", "Revisar el valor del campo que se indica en \"details\"."),
    UNKNOWN_PROPERTY("-2", "Uno o varios campos del request tienen nombres incorrectos.", "Revisar el nombre del campo que se indica en \"details\"."),
    INVALID_DATE_FORMAT("-3", "Error en el formato de fecha.", "Por favor enviar la fecha en el formato correcto.");

    private final String code;
    private final String message;
    private final String recommendation;
}
