package com.indium.StockService.repository;

import com.indium.StockService.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    List<Transactions> findByUserId(Long userId);

}
