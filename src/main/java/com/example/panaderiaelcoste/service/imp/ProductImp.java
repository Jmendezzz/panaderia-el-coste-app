package com.example.panaderiaelcoste.service.imp;

import com.example.panaderiaelcoste.model.Product;
import com.example.panaderiaelcoste.service.ProductService;

import java.util.ArrayList;

public class ProductImp implements ProductService {

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public ArrayList<Product> getProducts (){
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }


}
