package com.globant.controller;

import com.globant.model.UserAccount;

import java.util.HashMap;
import java.util.Scanner;

public class AuthenticationManager {
    private final HashMap<String, UserAccount> userAccounts = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private UserAccount currentUser = null;
    private final MainMenu mainMenu;
    private final SubMenu subMenu;
    private final AuthenticationService authService;

    public AuthenticationManager() {
        mainMenu = new MainMenu(scanner, this);
        subMenu = new SubMenu(scanner, this);
        authService = new AuthenticationService(userAccounts);
    }

    public void displayMenu() {
        while (true) {
            if (currentUser == null) {
                mainMenu.showMainMenu();
            } else {
                subMenu.showSubMenu(currentUser);
            }
        }
    }

    public void loginUser(String email, String password) {
        currentUser = authService.loginUser(email, password);
        if (currentUser != null) {
            System.out.println("Login successful, welcome.");
        } else {
            System.out.println("Invalid email or password, TRY AGAIN!.");
        }
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logged out successfully.");
    }

    public void setCurrentUser(UserAccount user) {
        this.currentUser = user;
    }

    public UserAccount getCurrentUser() {
        return currentUser;
    }

    public HashMap<String, UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
