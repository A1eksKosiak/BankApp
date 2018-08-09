package com.bank;

public interface AccountHolderInterface {

    void addMoney(double money);

    void withdrawMoney(double money);

    void addNewAccount(Currency currency);

    String getUniqueIdentifier();
}
