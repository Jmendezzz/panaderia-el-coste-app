package com.example.panaderiaelcoste.conecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String url = "jdbc:mysql://localhost:3306/panaderia_el_coste";
    private static String username = "root";
    private static String password = "admin123";

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(url, username, password);
    }
}
