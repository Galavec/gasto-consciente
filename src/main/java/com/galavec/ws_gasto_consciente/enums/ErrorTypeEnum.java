package com.galavec.ws_gasto_consciente.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Clase Enum que representa diferentes tipos de errores que pueden producirse en la aplicación.
 * Cada tipo de error incluye un código, un mensaje y una recomendación para resolver el error.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum ErrorTypeEnum {

    /**
     * Tipo de error que indica que el tamaño de los valores enviados en la solicitud es incorrecto.
     * <p>Code: -1</p>
     * <p>Message: Tamaño incorrecto de los valores que se envían en el request.</p>
     * <p>Recommendation: Revisar el valor del campo que se indica en "details".</p>
     *
     * @since 1.0.0
     */
    INCORRECT_SIZE("-1", "Tamaño incorrecto de los valores que se envían en el request.", "Revisar el valor del campo que se indica en \"details\"."),

    /**
     * Tipo de error que indica que uno o más campos de la solicitud tienen nombres incorrectos.
     * <p>Code: -2</p>
     * <p>Message: Uno o varios campos del request tienen nombres incorrectos.</p>
     * <p>Recommendation: Revisar el nombre del campo que se indica en "details".</p>
     *
     * @since 1.0.0
     */
    UNKNOWN_PROPERTY("-2", "Uno o varios campos del request tienen nombres incorrectos.", "Revisar el nombre del campo que se indica en \"details\"."),

    /**
     * Tipo de error que indica que hay un error en el formato de fecha.
     * <p>Code: -3</p>
     * <p>Message: Error en el formato de fecha.</p>
     * <p>Recommendation: Por favor enviar la fecha en el formato correcto.</p>
     *
     * @since 1.0.0
     */
    INVALID_DATE_FORMAT("-3", "Error en el formato de fecha.", "Por favor enviar la fecha en el formato correcto.");

    private final String code;
    private final String message;
    private final String recommendation;
}
