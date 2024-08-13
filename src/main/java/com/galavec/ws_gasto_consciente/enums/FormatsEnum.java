package com.galavec.ws_gasto_consciente.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Clase Enum que representa diferentes formatos de fecha y hora.
 * Cada formato incluye una cadena de formato específica.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum FormatsEnum {

    /**
     * Formato de fecha y hora en el patrón "yyyy-MM-dd'T'HH:mm:ss".
     *
     * @since 1.0.0
     */
    DATETIME_YYYY_MM_DD_T_HH_MM_SS("yyyy-MM-dd'T'HH:mm:ss");

    private final String format;
}
