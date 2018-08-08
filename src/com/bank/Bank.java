package com.bank;

import java.util.HashMap;

public class Bank {

    private String bankName;

    private HashMap clients;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.clients = new HashMap();
    }

    public String getBankName() {
        return bankName;
    }

    public void addUser(String password,
                        String fullName,
                        String address,
                        String phoneNumber,
                        String email,
                        String secretQuestion,
                        String answerForSecretQuestion) {
        AccountHolder newAccountHolder = new User(password, fullName, address, phoneNumber, email, secretQuestion, answerForSecretQuestion);
        clients.put(newAccountHolder.getId(), newAccountHolder);
    }

    public void addUser(AccountHolder accountHolder) {
        clients.put(accountHolder.getId(), accountHolder);
    }

    public Double totalAmountOfMoney(String userID) {
        if (clients.get(userID) != null) {
            AccountHolder accountHolder = (AccountHolder) clients.get(userID);
            return accountHolder.totalAmount();
        }
        return null;
    }

    public double totalAmountOfMoney(AccountHolder accountHolder) {
        return accountHolder.totalAmount();
    }

    public void addMoneyToUser(String userID, long accountID, double amountOfMoney) {
        if (clients.get(userID) != null) {
            AccountHolder accountHolder = (AccountHolder) clients.get(userID);
            accountHolder.addMoneyToAccount(accountID, amountOfMoney);
        }
    }

    public boolean findUser(String userId) {
        if (clients.get(userId) != null) {
            return true;
        }
        return false;
    }

    public void addAccountToUser(String userId, Currency currency) {
        if (clients.get(userId) != null) {
            AccountHolder accountHolder = (AccountHolder) clients.get(userId);
            accountHolder.addNewAccount(currency);
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", clients=" + clients +
                '}';
    }
}
