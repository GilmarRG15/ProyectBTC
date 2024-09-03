package com.globant.controller;

import com.globant.model.UserAccount;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenu {
    private final Scanner scanner;
    private final AuthenticationManager authManager;

    public SubMenu(Scanner scanner, AuthenticationManager authManager) {
        this.scanner = scanner;
        this.authManager = authManager;
    }

    public void showSubMenu(UserAccount currentUser) {
        HashMap<Integer, Runnable> subMenuActions = new HashMap<>();
        subMenuActions.put(1, authManager::logout);
        // Otros casos específicos...

        System.out.println("\n**- WELCOME TO THE CRYPTOCURRENCY BUYING AND SELLING APP -**");
        System.out.println("\n-** SUBMENU **-");
        System.out.println("1. Logout");
        // Otros casos de menú...
        System.out.print("Select Option: ");

        try {
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining line

            Runnable action = subMenuActions.get(option);
            if (action != null) {
                action.run();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter an integer.");
            scanner.nextLine(); // Clear the scanner buffer
        }
    }
}

