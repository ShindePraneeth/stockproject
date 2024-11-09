package com.indium.StockService.controller;

import com.indium.StockService.entity.Asset;
import com.indium.StockService.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
