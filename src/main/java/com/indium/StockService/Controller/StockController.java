package com.indium.StockService.Controller;


import com.indium.StockService.VMModel.StockVM;
import com.indium.StockService.Service.StockDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockController {
    private final StockDetailService stockDetailSerivce;

    @GetMapping("/get-stocks")
    public List<StockVM> getAllStocks() {
        return stockDetailSerivce.getAllStocks();
    }







}
