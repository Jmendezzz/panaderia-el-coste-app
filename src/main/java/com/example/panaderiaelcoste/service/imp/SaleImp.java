package com.example.panaderiaelcoste.service.imp;

import com.example.panaderiaelcoste.model.Sale;
import com.example.panaderiaelcoste.service.SaleService;

import java.util.ArrayList;

public class SaleImp implements SaleService {

    ArrayList<Sale> sales = new ArrayList<>();

    @Override
    public ArrayList<Sale> getSales(){
        return sales;
    }
}
