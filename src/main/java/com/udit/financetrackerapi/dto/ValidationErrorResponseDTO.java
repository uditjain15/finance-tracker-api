package com.udit.financetrackerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponseDTO {

    private List<ValidationErrorDTO> errors;
}