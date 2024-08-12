package com.galavec.ws_gasto_consciente.dto;

import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    private String codError;
    private String message;
    private String details;
    private String recommendation;

    public ErrorResponseDto(ErrorTypeEnum errorTypeEnum, String details) {
        this.codError = errorTypeEnum.getCode();
        this.message = errorTypeEnum.getMessage();
        this.details = details;
        this.recommendation = errorTypeEnum.getRecommendation();
    }
}
