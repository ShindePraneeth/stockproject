package com.indium.StockService.Service;


import com.indium.StockService.Repository.StockRepository;
import com.indium.StockService.VMModel.StockVM;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockDetailServiceImpl implements StockDetailService {

    private StockRepository stockRepository;

    @Override
    public List<StockVM> getAllStocks() {
        var stocks = stockRepository.findAll();
        var stockVMs = stocks.stream()
                .map(stock -> {
                    StockVM stockVM = new StockVM();
                    stockVM.setName(stock.getName());
                    stockVM.setPrice(stock.getPrice());
                    return stockVM;
                })
                .collect(Collectors.toList());

        return stockVMs;
    }
}




