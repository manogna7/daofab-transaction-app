package com.daofab.transactions.controller;

import com.daofab.transactions.ParentTransaction;
import com.daofab.transactions.service.ParentTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/parent-transactions")

public class ParentTransactionController {
    private final ParentTransactionService parentTransactionService;

    @Autowired
    public ParentTransactionController(ParentTransactionService parentTransactionService) {
        this.parentTransactionService = parentTransactionService;
    }

    @GetMapping("/parent-transactions")
    public ResponseEntity<List<ParentTransaction>> getParentTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        try {
            List<ParentTransaction> parentTransactions = parentTransactionService.getParentTransactions(page, pageSize, sortBy);
            return ResponseEntity.ok(parentTransactions);
        } catch (IOException e) {
            // Handle the exception appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
