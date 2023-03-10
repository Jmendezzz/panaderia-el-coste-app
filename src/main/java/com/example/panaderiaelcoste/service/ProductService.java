package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.model.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getProducts();

    void addProduct(Product product);

    void deleteProductById(String id);
}
