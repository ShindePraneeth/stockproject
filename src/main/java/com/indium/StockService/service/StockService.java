package com.indium.StockService.service;

import com.indium.StockService.dto.BitDto;
import com.indium.StockService.entity.Asset;
import com.indium.StockService.entity.Bit;
import com.indium.StockService.entity.Holding;
import com.indium.StockService.entity.Transactions;
import com.indium.StockService.repository.AssetRepository;
import com.indium.StockService.repository.BitRepository;
import com.indium.StockService.repository.HoldingRepository;
import com.indium.StockService.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private BitRepository bitRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private HoldingRepository holdingRepository;

    public List<Asset> getAllStocks() {
        return assetRepository.findAll();
    }

    public void postBuyOrSell(BitDto bitDto) {
        Bit bitReq = Bit.builder().
                userId(bitDto.getUserId())
                .assetId(bitDto.getAssetId())
                .quantity(bitDto.getQuantity())
                .buyOrSell(bitDto.getBuyOrSell())
                .status("Pending")
                .build();
        bitRepository.save(bitReq);
        if (bitDto.getBuyOrSell().equals("B")) {
            List<Bit> bitDataList = bitRepository.getBuyOrSellRecords("S", bitDto.getQuantity(), bitDto.getAssetId());
            if (bitDataList.size() > 0) {
                Transactions transactions = Transactions.builder()
                        .assetId(bitDto.getAssetId())
                        .quantity(bitDto.getQuantity())
                        .userId(bitDto.getUserId())
                        .buyerId(bitDto.getUserId())
                        .sellerId(bitDataList.get(0).getUserId())
                        .build();
                Holding buyerHolding = holdingRepository.findByAssetIdAndUserId(bitReq.getAssetId(), bitDto.getUserId()).get(0);
                buyerHolding.setQuantity(buyerHolding.getQuantity() + bitDto.getQuantity());
                Asset asset = assetRepository.findById(bitDto.getAssetId()).get();
                buyerHolding.setBalance(new BigDecimal(buyerHolding.getBalance().intValue() - (bitDto.getQuantity()) * asset.getPrice().intValue()));
                holdingRepository.save(buyerHolding);
                Holding sellerHolding = holdingRepository.findByAssetIdAndUserId(bitReq.getAssetId(), bitDataList.get(0).getUserId()).get(0);
                sellerHolding.setQuantity(sellerHolding.getQuantity() - bitDto.getQuantity());
                sellerHolding.setBalance(new BigDecimal(sellerHolding.getBalance().intValue() + (bitDto.getQuantity()) * asset.getPrice().intValue()));
                holdingRepository.save(sellerHolding);
                transactionsRepository.save(transactions);
            }
        }
    }
}
