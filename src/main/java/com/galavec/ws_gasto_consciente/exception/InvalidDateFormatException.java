package com.galavec.ws_gasto_consciente.exception;

/**
 * Clase para controlar las excepciones por formato de fecha incorrecta.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
public class InvalidDateFormatException extends RuntimeException {

    /**
     * Excepción que se lanza cuando se encuentra un formato de fecha inválido.
     *
     * @param message el mensaje detallado que describe el error de formato de fecha.
     * @since 1.0.0
     */
    public InvalidDateFormatException(String message) {
        super(message);
    }
}
