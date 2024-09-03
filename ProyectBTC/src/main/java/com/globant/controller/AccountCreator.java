package com.globant.controller;

import com.globant.model.UserAccount;
import com.globant.model.UserRole;

import java.util.HashMap;
import java.util.Scanner;

public class AccountCreator {
    private final HashMap<String, UserAccount> userAccounts;
    private final Scanner scanner;
    private int countID;

    public AccountCreator(HashMap<String, UserAccount> userAccounts, Scanner scanner) {
        this.userAccounts = userAccounts;
        this.scanner = scanner;
        this.countID = 1; // Start countID from 1
    }

    public void execute() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String ID_user = generateUserCode();
        System.out.print("Select your role (1 for Buyer, 2 for Seller): ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        UserRole role = (roleChoice == 2) ? new UserRole("Seller") : new UserRole("Buyer");

        UserAccount newUser = new UserAccount(ID_user, name, email, password, 0.0, role);

        if ("Seller".equals(role.getRole())) {
            newUser.addBalance(100.0);
            System.out.println("The system has granted you 100 BTC upon registration.");
        }

        userAccounts.put(email, newUser);
        System.out.println("Account successfully created.");
        System.out.println("Your user code is: " + newUser.getID_user());
    }

    private String generateUserCode() {
        return String.format("USR%03d", countID++);
    }
}
