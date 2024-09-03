package com.globant.model;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String ID_user;
    private String name;
    private String email;
    private String password;
    private double balance;
    private UserRole role;
    private List<Purchase> purchaseHistory;
    private List<Purchase> salesHistory;

    public UserAccount(String ID_user, String name, String email, String password, double balance, UserRole role) {
        this.ID_user = ID_user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.role = role;
        this.purchaseHistory = new ArrayList<>();
        this.salesHistory = new ArrayList<>();
    }

    public UserAccount(String email, String password, String name) {
    }

    public void recordPurchase(double amount, double pricePerBTC, UserAccount seller) {
        Purchase purchase = new Purchase(amount, pricePerBTC, seller);
        this.purchaseHistory.add(purchase);
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void recordSale(double amount, double pricePerBTC, UserAccount buyer) {
        Purchase sale = new Purchase(amount, pricePerBTC, buyer);
        this.salesHistory.add(sale);
    }

    public List<Purchase> getSalesHistory() {
        return salesHistory;
    }

    public String getID_user() {
        return ID_user;
    }

    public void setID_user(String ID_user) {
        this.ID_user = ID_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void subtractBalance(double amount) {
        this.balance -= amount;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

