package com.example.panaderiaelcoste.controller;

import com.example.panaderiaelcoste.model.Product;
import com.example.panaderiaelcoste.service.ServiceManager;
import com.example.panaderiaelcoste.singleton.Singleton;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "products",value = "/products")
public class ProductController extends HttpServlet{

    ServiceManager serviceManager = Singleton.getInstance();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name =request.getParameter("name");

        int  avaibleAmount = Integer.parseInt(request.getParameter("avaibleAmount")) ;
        String urlImage = request.getParameter("urlImage");
        boolean status = Boolean.parseBoolean(request.getParameter("status")) ;
        double  price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(name,avaibleAmount,status,price,urlImage);
        System.out.println(product.getName());
        serviceManager.getProductService().addProduct(product);

        response.sendRedirect("products.jsp");


    }




}
