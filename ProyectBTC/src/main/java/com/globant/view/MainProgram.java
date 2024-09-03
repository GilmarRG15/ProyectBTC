package com.globant.view;

import com.globant.controller.AuthenticationManager;

public class MainProgram {
    public static void main(String[] args) {
        AuthenticationManager authManager = new AuthenticationManager();
        authManager.displayMenu();
    }
}
