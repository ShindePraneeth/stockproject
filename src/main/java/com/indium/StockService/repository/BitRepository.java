package com.indium.StockService.repository;

import com.indium.StockService.entity.Bit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitRepository extends JpaRepository<Bit, Integer> {
    @Query(value = "select * from Bit where buyOrSell = :buyOrSell and quantity = :quantity and assetId = :assetId", nativeQuery = true)
    List<Bit> getBuyOrSellRecords(@Param("buyOrSell") String buyOrSell, @Param("quantity") Integer quantity, @Param("assetId") Integer assetId);
}
