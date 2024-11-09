package com.indium.StockService.service;

import com.indium.StockService.entity.Asset;
import com.indium.StockService.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllStocks() {
        return assetRepository.findAll();
    }
}
