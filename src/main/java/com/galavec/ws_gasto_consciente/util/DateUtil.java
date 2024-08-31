package com.galavec.ws_gasto_consciente.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utilidad para operaciones con fechas y horas.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
public class DateUtil {

    /**
     * Formateador de fecha y hora en el patrón "yyyy-MM-dd'T'HH:mm:ss".
     *
     * @since 1.0.0
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * Constructor privado para evitar que se instance la clase.
     *
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private DateUtil() {
        throw new UnsupportedOperationException("Esta es una clase de utilidad y no se la debe instanciar.");
    }

    /**
     * Obtiene la fecha y hora actual formateada como {@link LocalDateTime}.
     *
     * @return La fecha y hora actual como {@link LocalDateTime}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public static LocalDateTime getCurrentDateTimeWithLocalDateTime() {
        String formattedDate = LocalDateTime.now().format(FORMATTER);

        return LocalDateTime.parse(formattedDate, FORMATTER);
    }
}