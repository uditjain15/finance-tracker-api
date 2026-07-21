package com.udit.financetrackerapi.service;

import com.udit.financetrackerapi.entity.Transaction;
import com.udit.financetrackerapi.exception.TransactionNotFoundException;
import com.udit.financetrackerapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> saveTransactions(List<Transaction> transactions) {
        return transactionRepository.saveAll(transactions);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id: " + id));
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id: " + id));
        existingTransaction.setTitle(updatedTransaction.getTitle());
        existingTransaction.setAmount(updatedTransaction.getAmount());
        existingTransaction.setCategory(updatedTransaction.getCategory());
        existingTransaction.setType(updatedTransaction.getType());
        existingTransaction.setDate(updatedTransaction.getDate());
        return transactionRepository.save(existingTransaction);
    }

    public Transaction patchTransaction(Long id, Map<String, Object> updates) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id: " + id));
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

        return transactionRepository.save(existingTransaction);
    }

    public String deleteTransaction(Long id) {
        transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id: " + id));
        getTransactionById(id);
        transactionRepository.deleteById(id);
        return "Transaction deleted successfully.";
    }
}