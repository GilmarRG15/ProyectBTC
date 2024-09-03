package com.globant.controller;

import com.globant.model.UserAccount;
import com.globant.model.SellOffer;

import java.util.List;
import java.util.Scanner;

public class OfferManager {
    private final Scanner scanner;
    private final List<SellOffer> sellOffers;

    public OfferManager(Scanner scanner, List<SellOffer> sellOffers) {
        this.scanner = scanner;
        this.sellOffers = sellOffers;
    }

    public void execute(UserAccount user) {
        System.out.print("Enter the price per BTC: ");
        double price = scanner.nextDouble();
        System.out.print("Enter the amount of BTC: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        SellOffer offer = new SellOffer(user, price, amount);
        sellOffers.add(offer);

        System.out.println("Offer created successfully.");
    }
}

