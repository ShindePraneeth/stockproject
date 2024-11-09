package com.indium.StockService.VMModel;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class StockVM {

    private String name;
    private double price;
}