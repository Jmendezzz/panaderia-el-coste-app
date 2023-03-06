package com.example.panaderiaelcoste.service;

import com.example.panaderiaelcoste.exception.LoginException;

public interface LoginService {

    boolean verifyEmployeeLoginCredentials(String username, String password) throws LoginException;

    boolean verifyAdminLoginCredentials(String username, String password) throws LoginException;
}
