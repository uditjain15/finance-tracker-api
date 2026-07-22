package com.udit.financetrackerapi.exception;

import com.udit.financetrackerapi.dto.ErrorResponse;
import com.udit.financetrackerapi.dto.ValidationErrorDTO;
import com.udit.financetrackerapi.dto.ValidationErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTransactionNotFoundException(TransactionNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleHandlerMethodValidationException(
            HandlerMethodValidationException ex) {

        List<ValidationErrorDTO> errors = new ArrayList<>();

        ex.getParameterValidationResults().forEach(result -> {

            if (result instanceof ParameterErrors parameterErrors) {

                int index = parameterErrors.getContainerIndex();

                for (FieldError fieldError : parameterErrors.getFieldErrors()) {

                    errors.add(new ValidationErrorDTO(
                            index,
                            fieldError.getField(),
                            fieldError.getDefaultMessage()
                    ));
                }
            }
        });

        return ResponseEntity.badRequest()
                .body(new ValidationErrorResponseDTO(errors));
    }
}