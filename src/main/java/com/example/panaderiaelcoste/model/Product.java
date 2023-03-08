package com.example.panaderiaelcoste.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String name;
    private int avaibleAmount;
    private String urlImage;
    private boolean status;

    private double price;

    public Product(String name, int avaibleAmount, boolean status, double price,String urlImage) {
        this.name = name;
        this.avaibleAmount = avaibleAmount;
        this.status = status;
        this.price = price;
        this.urlImage = urlImage;
    }
}
