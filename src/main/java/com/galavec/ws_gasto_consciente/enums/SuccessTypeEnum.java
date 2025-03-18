package com.galavec.ws_gasto_consciente.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Clase Enum que representa diferentes tipos de respuestas exitosas que pueden producirse en la aplicación.
 * Cada tipo de respuesta exitosa incluye un código y un mensaje.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum SuccessTypeEnum {

    /**
     * Tipo de respuesta exitosa que indica que se realizó satisfactoriamente la inserción del registro en la base de datos.
     * <p>Code: 4</p>
     * <p>Message: Se insertó exitosamente el registro en la base de datos.</p>
     *
     * @since 1.0.0
     */
    DATA_INSERTION_SUCCESS("4", "Se insertó exitosamente el registro en la base de datos."),

    /**
     * Tipo de respuesta exitosa que indica que se realizó satisfactoriamente el proceso.
     * <p>Code: 200</p>
     * <p>Message: Ejecución exitosa.</p>
     *
     * @since 1.0.0
     */
    SUCCESSFUL_EXECUTION("200", "Ejecución exitosa.");

    private final String code;
    private final String message;
}
