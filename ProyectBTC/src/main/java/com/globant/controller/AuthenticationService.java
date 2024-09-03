package com.globant.controller;

import com.globant.model.UserAccount;

import java.util.HashMap;

public class AuthenticationService {
    private final HashMap<String, UserAccount> userAccounts;

    public AuthenticationService(HashMap<String, UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public UserAccount loginUser(String email, String password) {
        UserAccount user = userAccounts.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void createUser(String email, String password, String name) {
        UserAccount user = new UserAccount(email, password, name);
        userAccounts.put(email, user);
    }
}
