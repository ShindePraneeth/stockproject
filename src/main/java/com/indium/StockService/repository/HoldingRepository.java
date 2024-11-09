package com.indium.StockService.repository;

import com.indium.StockService.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingRepository extends JpaRepository<Holding, Integer> {

    public List<Holding> findByAssetIdandUserId(Integer assetId, Integer userId);
}
