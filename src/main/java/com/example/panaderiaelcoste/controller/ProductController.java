package com.example.panaderiaelcoste.controller;

import com.example.panaderiaelcoste.model.Product;
import com.example.panaderiaelcoste.service.ServiceManager;
import com.example.panaderiaelcoste.singleton.Singleton;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



@WebServlet(name = "products",value = "/products")
public class ProductController extends HttpServlet{

    ServiceManager serviceManager = Singleton.getInstance();
    ArrayList<String> errors = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();




    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        errors.clear();

        HttpSession session =request.getSession();
        String isDelete = request.getParameter("idDelete");

       String method = isDelete==  null ? "POST" : "DELETE";

        switch (method){
            case "POST":
                String name =request.getParameter("name");
                validateInput("name",name);
                String avaibleAmount = request.getParameter("avaibleAmount") ;
                validateInput("avaibleAmount",avaibleAmount);
                String status = request.getParameter("status") ;
                validateInput("status",status);
                String price = request.getParameter("price");
                validateInput("price",price);
                String urlImage = request.getParameter("urlImage");
                validateInput("urlImage",urlImage);

                System.out.println(objectMapper.writeValueAsString(errors));
                session.setAttribute("errors",objectMapper.writeValueAsString(errors));

                if(!(errors.size() >0)){
                    Product product = createProduct(name,avaibleAmount,status,price,urlImage);
                    System.out.println(product.getName());
                    serviceManager.getProductService().addProduct(product);

                    doGet(request,response);
                }
                break;
            case "DELETE":
                doDelete(request,response);
                doGet(request,response); //Actualizar tabla en el front
                break;

        }
        response.sendRedirect("products.jsp");
        /*Al final decidi implementarlo asi ya que aunque con el otro metodo podia guardar el value de los inputs en caso de error
        al dar enviar se quedaban todos los datos en los inputs y no se reestablecian.
        */


    }

    public void validateInput(String key, String value){
        if(value == null || value.isEmpty()){
            errors.add(key);
        }
    }
    public Product createProduct(String name, String avaibleAmount, String status, String price, String urlmage){

        int avaibleAmountParsed = Integer.parseInt(avaibleAmount);
        boolean statusParsed = Boolean.parseBoolean(status);
        int priceParsed = Integer.parseInt(price);

        return new Product(name,avaibleAmountParsed, statusParsed,priceParsed, urlmage);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        ArrayList<Product> products = serviceManager.getProductService().getProducts();
        System.out.println(objectMapper.writeValueAsString(products));
        System.out.println("Getting...");
        HttpSession session = request.getSession();
        session.setAttribute("products",objectMapper.writeValueAsString(products));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Deleting...");

        String id = request.getParameter("idDelete");

        serviceManager.getProductService().deleteProductById(id);


    }








}
