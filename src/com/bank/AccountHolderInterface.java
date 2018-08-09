package com.bank;

public interface AccountHolderInterface {

    void addMoney(double money);

    void withdrawMoney(double money);

    String getUniqueIdentifier();
}
