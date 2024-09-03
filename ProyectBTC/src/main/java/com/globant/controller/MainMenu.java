package com.globant.controller;

import com.globant.model.UserAccount;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private final AuthenticationManager authManager;

    public MainMenu(Scanner scanner, AuthenticationManager authManager) {
        this.scanner = scanner;
        this.authManager = authManager;
    }

    public void showMainMenu() {
        HashMap<Integer, Runnable> mainMenuActions = new HashMap<>();
        mainMenuActions.put(1, this::loginUser);
        mainMenuActions.put(2, this::createAccount);
        mainMenuActions.put(3, this::quit);

        System.out.println("\n**-WELCOME TO THE CRYPTOCURRENCY BUYING AND SELLING APP-**");
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Quit");
        System.out.print("Select Option: ");

        try {
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining line

            Runnable action = mainMenuActions.get(option);
            if (action != null) {
                action.run();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error Please enter an integer.");
            scanner.nextLine(); // Clear the scanner buffer
        }
    }

    private void loginUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        authManager.loginUser(email, password);
    }

    private void createAccount() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        authManager.getUserAccounts().put(email, new UserAccount(email, password, name));
        System.out.println("Account created successfully.");
    }

    private void quit() {
        System.out.println("Exiting the application, have a nice day! ;) ");
        System.exit(0);
    }
}
