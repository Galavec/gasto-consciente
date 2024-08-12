package com.galavec.ws_gasto_consciente.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FormatsEnum {
    DATETIME_YYYY_MM_DD_T_HH_MM_SS("yyyy-MM-dd'T'HH:mm:ss");

    private final String format;
}
