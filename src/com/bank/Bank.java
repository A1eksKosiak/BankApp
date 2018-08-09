package com.bank;

import com.bank.Old.AccountHolder;
import com.bank.Old.User;

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
        AccountHolderInterface newAccountHolder = new UserAccountHolderInterface(password, fullName, address, phoneNumber, email, secretQuestion, answerForSecretQuestion);
        clients.put(newAccountHolder.getUniqueIdentifier(), newAccountHolder);
    }

    public void addUser(AccountHolderInterface accountHolder) {
        clients.put(accountHolder.getUniqueIdentifier(), accountHolder);
    }

    public Double totalAmountOfMoney(String userID) {
        if (clients.get(userID) != null) {
            AccountHolderInterface accountHolder = (AccountHolderInterface) clients.get(userID);
            return accountHolder.totalAmount();
        }
        return null;
    }

    public double totalAmountOfMoney(AccountHolder accountHolder) {
        return accountHolder.totalAmount();
    }

    public void addMoneyToUser(String userID, double amountOfMoney) {
        if (clients.get(userID) != null) {
            AccountHolderInterface accountHolder = (AccountHolderInterface) clients.get(userID);
            accountHolder.addMoney(amountOfMoney);
        }
    }

    public void withdrawMoneyFromUser(String userId, double money) {
        if (clients.get(userId) != null) {
            AccountHolderInterface accountHolder = (AccountHolderInterface) clients.get(userId);
            accountHolder.withdrawMoney(money);
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
            AccountHolderInterface accountHolder = (AccountHolderInterface) clients.get(userId);
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
