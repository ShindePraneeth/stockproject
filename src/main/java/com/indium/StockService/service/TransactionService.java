package com.indium.StockService.service;

import com.indium.StockService.entity.Transactions;
import com.indium.StockService.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<Transactions> getAllTransactionsByUserId(Long userId) {
        return transactionsRepository.findByUserId(userId);
    }
}
