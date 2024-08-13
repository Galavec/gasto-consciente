package com.galavec.ws_gasto_consciente.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.galavec.ws_gasto_consciente.enums.FormatsEnum;
import com.galavec.ws_gasto_consciente.exception.InvalidDateFormatException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Clase usada como deserializador personalizado para objetos {@code LocalDateTime}.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FormatsEnum.DATETIME_YYYY_MM_DD_T_HH_MM_SS.getFormat());

    /**
     * Deserializa una cadena de texto en un objeto {@code LocalDateTime}.
     *
     * @param jsonParser             el {@code JsonParser} utilizado para leer la cadena de texto.
     * @param deserializationContext el contexto de deserialización.
     * @return el objeto {@code LocalDateTime} deserializado.
     * @throws IOException sí ocurre un error de entrada/salida durante la deserialización.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateText = jsonParser.getText();

        return parseDate(dateText);
    }

    /**
     * Parsea una cadena de texto en un objeto {@code LocalDateTime}.
     *
     * @param dateText la cadena de texto que representa la fecha y hora.
     * @return el objeto {@code LocalDateTime} parseado.
     * @throws InvalidDateFormatException si el formato de la fecha es inválido.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private LocalDateTime parseDate(String dateText) throws InvalidDateFormatException {
        StringBuilder messageError = new StringBuilder();

        try {
            return LocalDateTime.parse(dateText, FORMATTER);
        } catch (DateTimeParseException e) {
            messageError.append("La fecha es inválida. Por favor, elige una fecha válida con el formato: ").append(FormatsEnum.DATETIME_YYYY_MM_DD_T_HH_MM_SS.getFormat());

            throw new InvalidDateFormatException(messageError.toString());
        }
    }
}