package com.udit.financetrackerapi.controller;

import com.udit.financetrackerapi.entity.Transaction;
import com.udit.financetrackerapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @PostMapping("/bulk")
    public List<Transaction> addTransactions(@RequestBody List<Transaction> transactions) {
        return transactionService.saveTransactions(transactions);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id,
                                         @RequestBody Transaction updatedTransaction) {

        return transactionService.updateTransaction(id, updatedTransaction);
    }

    @PatchMapping("/{id}")
    public Transaction patchTransaction(@PathVariable Long id,
                                        @RequestBody Map<String, Object> updates) {
        return transactionService.patchTransaction(id, updates);
    }

    @DeleteMapping("/{id}")
    public String deleteTransactionById(@PathVariable Long id) {
        return transactionService.deleteTransaction(id);
    }
}