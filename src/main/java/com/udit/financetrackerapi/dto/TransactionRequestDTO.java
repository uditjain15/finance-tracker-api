package com.udit.financetrackerapi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionRequestDTO {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Date is required")
    private LocalDate date;
}
