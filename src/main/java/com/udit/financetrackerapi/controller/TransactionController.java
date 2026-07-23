package com.udit.financetrackerapi.controller;

import com.udit.financetrackerapi.dto.TransactionRequestDTO;
import com.udit.financetrackerapi.dto.TransactionResponseDTO;
import com.udit.financetrackerapi.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
@Tag(
        name = "Transactions",
        description = "APIs for managing finance transactions"
)
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Add single transaction
    @Operation(
            summary = "Create a new transaction",
            description = "Creates a new finance transaction."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transaction created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data or validation failed"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public TransactionResponseDTO addTransaction(@Valid @RequestBody TransactionRequestDTO request) {
        return transactionService.saveTransaction(request);
    }

    // Add multiple transactions
    @Operation(
            summary = "Create multiple transactions",
            description = "Creates multiple finance transactions in a single request."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transactions created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data or validation failed"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/bulk")
    public List<TransactionResponseDTO> addTransactions(
             @RequestBody List<@Valid TransactionRequestDTO> requests) {
       // System.out.println("Bulk API reached");
        return transactionService.saveTransactions(requests);
    }

    // Get all transactions
    @Operation(
            summary = "Get all transactions",
            description = "Retrieves a list of all finance transactions."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transactions retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<TransactionResponseDTO> getAllTransactions() {

        return transactionService.getAllTransactions();
    }

    // Get a transaction by ID
    @Operation(
            summary = "Get transaction by ID",
            description = "Retrieves a finance transaction using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transaction retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public TransactionResponseDTO getTransactionById(
            @PathVariable Long id) {

        return transactionService.getTransactionById(id);
    }

    // Update an existing transaction completely
    @Operation(
            summary = "Update a transaction",
            description = "Replaces an existing finance transaction with the provided data."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transaction updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data or validation failed"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public TransactionResponseDTO updateTransaction(
            @PathVariable Long id,
            @Valid @RequestBody TransactionRequestDTO request) {

        return transactionService.updateTransaction(id, request);
    }

    // Update only specific fields of a transaction
    @Operation(
            summary = "Partially update a transaction",
            description = "Updates one or more fields of an existing finance transaction."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transaction updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PatchMapping("/{id}")
    public TransactionResponseDTO patchTransaction(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return transactionService.patchTransaction(id, updates);
    }

    // Delete a transaction by ID
    @Operation(
            summary = "Delete a transaction",
            description = "Deletes a finance transaction by its unique ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transaction deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public String deleteTransactionById(
            @PathVariable Long id) {

        return transactionService.deleteTransaction(id);
    }
}