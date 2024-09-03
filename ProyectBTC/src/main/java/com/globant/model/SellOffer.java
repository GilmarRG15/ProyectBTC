package com.globant.model;

public class SellOffer {
    private final UserAccount seller;
    private double price;
    private double amount;

    public SellOffer(UserAccount seller, double price, double amount) {
        this.seller = seller;
        this.price = price;
        this.amount = amount;
    }

    public UserAccount getSeller() {
        return seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
