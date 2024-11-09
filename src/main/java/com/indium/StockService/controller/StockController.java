package com.indium.StockService.controller;

import com.indium.StockService.dto.BitDto;
import com.indium.StockService.entity.Asset;
import com.indium.StockService.entity.Transactions;
import com.indium.StockService.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/getStocks")
    public List<Asset> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping("/buyOrSell")
    public void postBuyOrSell(BitDto bitDto) {
        stockService.postBuyOrSell(bitDto);
    }

    @GetMapping("/transactions/{userId}")
    public List<Transactions> getAllRecordsByUserId(@PathVariable Integer userId) {
        return stockService.getAllTransactionsByUserId(userId);
    }

}
