package com.example.panaderiaelcoste.filters;


import com.example.panaderiaelcoste.conecction.DataBaseConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class DataBaseConnectionFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try(Connection connection = DataBaseConnection.getConnection()) {

            if(connection.getAutoCommit()){
                connection.setAutoCommit(false);
            }
            try {
                System.out.println("Getting connection in filter");
                request.setAttribute("conn",connection);
                chain.doFilter(request,response);
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }

        } catch (SQLException e) {
            throw  new RuntimeException(e);
            }

    }
}
