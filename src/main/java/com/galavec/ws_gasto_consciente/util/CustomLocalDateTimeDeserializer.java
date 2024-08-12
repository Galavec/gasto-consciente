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
 * Deserializador personalizado para objetos LocalDateTime donde se valida su formato de fecha.
 */
public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FormatsEnum.DATETIME_YYYY_MM_DD_T_HH_MM_SS.getFormat());

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateText = jsonParser.getText();

        return parseDate(dateText);
    }

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