package com.galavec.ws_gasto_consciente.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDto {
    private String codError;
    private String message;
    private String details;
    private String recommendation;
}
