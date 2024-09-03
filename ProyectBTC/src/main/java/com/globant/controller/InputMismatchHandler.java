package com.globant.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchHandler {
    private final Scanner scanner;

    public InputMismatchHandler() {
        this.scanner = new Scanner(System.in);
    }

    public void getUserInput() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Ingrese un número: ");
                int number = scanner.nextInt();
                scanner.nextLine();

                // Procesa el número
                System.out.println("Number entered: " + number);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }
}
