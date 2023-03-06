package com.example.panaderiaelcoste.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employee {

    private String name;
    private String id;
    private String email;
    private  int itemsSold;
    private LoginCredential loginCredentials;

    public Employee(String name, String id, String email, int itemsSold, LoginCredential loginCredentials) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.itemsSold = itemsSold;
        this.loginCredentials = loginCredentials;
    }
}
