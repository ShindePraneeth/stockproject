package com.indium.StockService.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BitDto {

    private Integer userId;
    private Integer assetId;
    private Integer quantity;
    private String buyOrSell;
}
