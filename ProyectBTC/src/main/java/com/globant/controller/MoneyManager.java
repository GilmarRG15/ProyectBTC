package com.globant.controller;

import com.globant.model.UserAccount;

import java.util.Scanner;

public class MoneyManager {
    private final Scanner scanner;

    public MoneyManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute(UserAccount user) {
        if ("Buyer".equals(user.getRole().getRole())) {
            System.out.print("Enter the amount of money to add: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            user.addBalance(amount);
            System.out.println("Money added successfully. Your new balance is: $" + user.getBalance());
        } else {
            System.out.println("This option is only available for buyers.");
        }
    }
}
