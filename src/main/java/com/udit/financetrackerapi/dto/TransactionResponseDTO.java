package com.udit.financetrackerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionResponseDTO {

    private Long id;

    private String title;

    private Double amount;

    private String type;

    private String category;

    private LocalDate date;
}