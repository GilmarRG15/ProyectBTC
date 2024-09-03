package com.globant.model;

public class Purchase {
    private double amount;
    private double pricePerBTC;
    private UserAccount seller;

    public Purchase(double amount, double pricePerBTC, UserAccount seller) {
        this.amount = amount;
        this.pricePerBTC = pricePerBTC;
        this.seller = seller;
    }

    public double getAmount() {
        return amount;
    }

    public double getPricePerBTC() {
        return pricePerBTC;
    }

    public UserAccount getSeller() {
        return seller;
    }

    public double getTotalValue() {
        return amount * pricePerBTC;
    }

    @Override
    public String toString() {
        return String.format("Purchased %.2f BTC at $%.2f each, Total: $%.2f from %s",
                amount, pricePerBTC, getTotalValue(), seller.getName());
    }
}
