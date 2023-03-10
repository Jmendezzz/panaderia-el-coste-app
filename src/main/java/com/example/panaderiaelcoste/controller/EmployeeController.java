package com.example.panaderiaelcoste.controller;


import com.example.panaderiaelcoste.model.Sale;
import com.example.panaderiaelcoste.model.SaleDetail;
import com.example.panaderiaelcoste.service.ServiceManager;
import com.example.panaderiaelcoste.singleton.Singleton;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="employeeMainPage", value ="/employee")
public class EmployeeController extends HttpServlet {

    ServiceManager serviceManager  = Singleton.getInstance();

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String list = request.getParameter("data-sale");

        ArrayList<SaleDetail> saleDetails =objectMapper.readValue(list, new TypeReference<ArrayList<SaleDetail>>(){});

        for (SaleDetail saleDetail : saleDetails){
            System.out.println(saleDetail.getProduct().getName());
        }

        //response.sendRedirect("employee.jsp");

        System.out.println("Sale: " + list);

    }


}
