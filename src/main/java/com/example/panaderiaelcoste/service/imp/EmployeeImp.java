package com.example.panaderiaelcoste.service.imp;

import com.example.panaderiaelcoste.model.Employee;
import com.example.panaderiaelcoste.model.LoginCredential;
import com.example.panaderiaelcoste.service.EmployeeService;

import java.util.ArrayList;


public class EmployeeImp implements EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();
    public EmployeeImp(){

        employees.add(new Employee("Juan","123","jugmeen23@gmail.com",2,new LoginCredential("juan","1234")));

    }


    @Override
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
