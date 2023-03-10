package com.example.panaderiaelcoste.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDetail {

    private Product product;
    private int amount;

    public SaleDetail(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }
}
