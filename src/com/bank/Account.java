package com.bank;

public class Account {

    //transaction history
    //limits

    private double balance;
    private long accountNumber;
    private String currency;

    public Account(String currency) {
        this.balance = 0;
        this.accountNumber = 10000000 + (long) (Math.random() * 10000000L);
        this.currency = currency;
    }

    public void addMoneyToAccount(double moneyAmount) {
        balance += moneyAmount;
    }

    public boolean withdrawMoney(double moneyAmount) {
        if (balance < moneyAmount) {
            return false;
        }
        balance -= moneyAmount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNumber=" + accountNumber +
                ", currency='" + currency + '\'' +
                '}';
    }
}
