package com.globant.controller;

import com.globant.model.Purchase;
import com.globant.model.UserAccount;

import java.util.List;

public class BalanceChecker {

    public void execute(UserAccount user) {
        System.out.println("Your current balance is: $" + user.getBalance());

        List<Purchase> purchaseHistory = user.getPurchaseHistory();
        if (purchaseHistory.isEmpty()) {
            System.out.println("No purchase history available.");
        } else {
            System.out.println("Purchase History:");
            for (Purchase purchase : purchaseHistory) {
                System.out.println(purchase);
            }
        }
    }
}
