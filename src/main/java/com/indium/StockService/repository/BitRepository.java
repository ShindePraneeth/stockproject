package com.indium.StockService.repository;

import com.indium.StockService.entity.Bit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitRepository extends JpaRepository<Bit, Integer> {
}
