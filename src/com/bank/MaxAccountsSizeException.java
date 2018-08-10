package com.bank;

public class MaxAccountsSizeException extends Exception {

    double amount;

    public MaxAccountsSizeException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
