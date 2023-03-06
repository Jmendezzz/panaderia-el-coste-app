package com.example.panaderiaelcoste.controller;

import com.example.panaderiaelcoste.exception.LoginException;
import com.example.panaderiaelcoste.service.ServiceManager;
import com.example.panaderiaelcoste.singleton.Singleton;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "loginAuth",value = "/login-authentication")
public class LoginController extends HttpServlet {
    ServiceManager serviceManager = Singleton.getInstance(); // Obtengo la instancia que contiene todos los servicios

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.removeAttribute("error");
        session.removeAttribute("status");



        RequestDispatcher requestDispatcher = null;
        try {
            if (serviceManager.getLoginService().verifyEmployeeLoginCredentials(userName, password)) {
                requestDispatcher = request.getRequestDispatcher("main-page.jsp");
            } else {

                session.setAttribute("status", "failed");
                System.out.println(session.getAttribute("status"));
                requestDispatcher = request.getRequestDispatcher("index.jsp");

            }

        } catch (LoginException e) {
            session.setAttribute("error","Debe completar todos los campos para el inicio de sesión!");
            System.out.println(e.getMessage());
        }finally {
            requestDispatcher = request.getRequestDispatcher("index.jsp");
        }
        requestDispatcher.forward(request, response);
    }

}
