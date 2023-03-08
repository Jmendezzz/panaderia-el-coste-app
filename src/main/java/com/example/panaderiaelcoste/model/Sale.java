package com.example.panaderiaelcoste.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Sale {

    private Employee employee;
    private ArrayList<SaleDetail> saleDetails;

    private double total;

    public Sale(Employee employee, ArrayList<SaleDetail> saleDetails, double total) {
        this.employee = employee;
        this.saleDetails = saleDetails;
        this.total = total;
    }
}
