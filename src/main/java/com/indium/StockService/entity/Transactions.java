package com.indium.StockService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer assetId;
    private Integer userId;
    private Integer quantity;
    @Column(name = "Buy_or_Sell")
    private String buyOrSell;
    private Integer buyerId;
    private Integer sellerId;
}
