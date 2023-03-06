package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.service.imp.EmployeeImpl;
import com.example.panaderiaelcoste.service.imp.LoginImpl;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ServiceManager {

    private final  LoginService loginService;
    private final  EmployeeService employeeService;

    public ServiceManager(){
        employeeService = new EmployeeImpl();
        loginService = new LoginImpl(this);


    }

}
