package com.udit.financetrackerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorDTO {

    private int index;
    private String field;
    private String message;
}