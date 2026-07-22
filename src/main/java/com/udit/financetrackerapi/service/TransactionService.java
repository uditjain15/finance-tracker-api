package com.udit.financetrackerapi.service;

import com.udit.financetrackerapi.dto.TransactionRequestDTO;
import com.udit.financetrackerapi.dto.TransactionResponseDTO;
import com.udit.financetrackerapi.entity.Transaction;
import com.udit.financetrackerapi.exception.TransactionNotFoundException;
import com.udit.financetrackerapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Add only a single transaction
    public TransactionResponseDTO saveTransaction(TransactionRequestDTO request) {
        Transaction transaction = convertToEntity(request);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return convertToResponseDTO(savedTransaction);
    }

    // Add multiple transactions at once
    public List<TransactionResponseDTO> saveTransactions(List<TransactionRequestDTO> requests) {
        List<Transaction> transactions = new ArrayList<>();
        for (TransactionRequestDTO request : requests) {
            transactions.add(convertToEntity(request));
        }

        List<Transaction> savedTransactions = transactionRepository.saveAll(transactions);
        List<TransactionResponseDTO> responseList = new ArrayList<>();
        for (Transaction transaction : savedTransactions) {
            responseList.add(convertToResponseDTO(transaction));
        }
        return responseList;
    }

    // Get all transactions
    public List<TransactionResponseDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponseDTO> responseList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            responseList.add(convertToResponseDTO(transaction));
        }
        return responseList;
    }

    // Get a transaction by its ID
    public TransactionResponseDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() ->
                        new TransactionNotFoundException("Transaction not found with id: " + id));

        return convertToResponseDTO(transaction);
    }

    // Update an existing transaction completely
    public TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO request) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() ->
                        new TransactionNotFoundException("Transaction not found with id: " + id));

        existingTransaction.setTitle(request.getTitle());
        existingTransaction.setAmount(request.getAmount());
        existingTransaction.setCategory(request.getCategory());
        existingTransaction.setType(request.getType());
        existingTransaction.setDate(request.getDate());
        Transaction updatedTransaction = transactionRepository.save(existingTransaction);
        return convertToResponseDTO(updatedTransaction);
    }

    // Update only the provided fields of a transaction
    public TransactionResponseDTO patchTransaction(Long id, Map<String, Object> updates) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() ->
                        new TransactionNotFoundException("Transaction not found with id: " + id));

        if (updates.containsKey("title")) {
            existingTransaction.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("amount")) {
            existingTransaction.setAmount(((Number) updates.get("amount")).doubleValue());
        }
        if (updates.containsKey("type")) {
            existingTransaction.setType((String) updates.get("type"));
        }
        if (updates.containsKey("category")) {
            existingTransaction.setCategory((String) updates.get("category"));
        }
        if (updates.containsKey("date")) {
            existingTransaction.setDate(LocalDate.parse((String) updates.get("date")));
        }
        Transaction updatedTransaction = transactionRepository.save(existingTransaction);
        return convertToResponseDTO(updatedTransaction);
    }

    // Delete a transaction by its ID
    public String deleteTransaction(Long id) {
        transactionRepository.findById(id)
                .orElseThrow(() ->
                        new TransactionNotFoundException("Transaction not found with id: " + id));

        transactionRepository.deleteById(id);
        return "Transaction deleted successfully.";
    }

    // Convert Entity to Response DTO
    private TransactionResponseDTO convertToResponseDTO(Transaction transaction) {
        TransactionResponseDTO response = new TransactionResponseDTO();

        response.setId(transaction.getId());
        response.setTitle(transaction.getTitle());
        response.setAmount(transaction.getAmount());
        response.setType(transaction.getType());
        response.setCategory(transaction.getCategory());
        response.setDate(transaction.getDate());

        return response;
    }

    // Convert Request DTO to Entity
    private Transaction convertToEntity(TransactionRequestDTO request) {
        Transaction transaction = new Transaction();

        transaction.setTitle(request.getTitle());
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setCategory(request.getCategory());
        transaction.setDate(request.getDate());

        return transaction;
    }
}