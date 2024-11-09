package com.indium.StockService.controller;


import com.indium.StockService.entity.Transactions;
import com.indium.StockService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/{userId}")
    public List<Transactions> getAllRecordsByUserId(@PathVariable Long userId) {
        return transactionService.getAllTransactionsByUserId(userId);
    }
}