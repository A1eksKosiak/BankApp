package com.bank;

public interface AccountHolderInterface {

    void addMoney(double money) throws MaxAccountsSizeException;

    void withdrawMoney(double money);

    void addNewAccount(Currency currency);

    double totalAmount();

    String getUniqueIdentifier();
}
