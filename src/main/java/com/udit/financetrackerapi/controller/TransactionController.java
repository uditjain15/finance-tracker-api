package com.udit.financetrackerapi.controller;

import com.udit.financetrackerapi.dto.TransactionRequestDTO;
import com.udit.financetrackerapi.dto.TransactionResponseDTO;
import com.udit.financetrackerapi.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Add single transaction
    @PostMapping
    public TransactionResponseDTO addTransaction(@Valid @RequestBody TransactionRequestDTO request) {
        return transactionService.saveTransaction(request);
    }

    // Add multiple transactions
    @PostMapping("/bulk")
    public List<TransactionResponseDTO> addTransactions(
             @RequestBody List<@Valid TransactionRequestDTO> requests) {
       // System.out.println("Bulk API reached");
        return transactionService.saveTransactions(requests);
    }

    // Get all transactions
    @GetMapping
    public List<TransactionResponseDTO> getAllTransactions() {

        return transactionService.getAllTransactions();
    }

    // Get a transaction by ID
    @GetMapping("/{id}")
    public TransactionResponseDTO getTransactionById(
            @PathVariable Long id) {

        return transactionService.getTransactionById(id);
    }

    // Update an existing transaction completely
    @PutMapping("/{id}")
    public TransactionResponseDTO updateTransaction(
            @PathVariable Long id,
            @Valid @RequestBody TransactionRequestDTO request) {

        return transactionService.updateTransaction(id, request);
    }

    // Update only specific fields of a transaction
    @PatchMapping("/{id}")
    public TransactionResponseDTO patchTransaction(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return transactionService.patchTransaction(id, updates);
    }

    // Delete a transaction by ID
    @DeleteMapping("/{id}")
    public String deleteTransactionById(
            @PathVariable Long id) {

        return transactionService.deleteTransaction(id);
    }
}