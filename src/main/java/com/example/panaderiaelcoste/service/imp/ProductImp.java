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

    @Override
    public void deleteProductById(String id){

        Product product = products.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);


        products.remove(product);
        System.out.println(products.size());



    }


}
