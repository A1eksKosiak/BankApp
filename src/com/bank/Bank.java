package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String bankName;

    private List<AccountHolder> clients;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.clients = new ArrayList<>();
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
        clients.add(newAccountHolder);
    }

    public void addUser(AccountHolder accountHolder) {
        clients.add(accountHolder);
    }

    public Double totalAmountOfMoney(String userID) {
        for (AccountHolder accountHolder : clients) {
            if (accountHolder.getId().equals(userID)) {
                return accountHolder.totalAmount();
            }
        }
        return null;
    }

    public double totalAmountOfMoney(AccountHolder accountHolderr) {
        return accountHolderr.totalAmount();
    }

    public void addMoneyToUser(String userID, long accountID, double amountOfMoney) {
        for (AccountHolder accountHolder : clients) {
            if (accountHolder.getId().equals(userID)) {
                accountHolder.addMoneyToAccount(accountID, amountOfMoney);
                return;
            }
        }
    }

    public String getUserID(String userName) {
        if (findUser(userName)) {
            for (AccountHolder accountHolder : clients) {
                if (accountHolder.getName() == userName) {
                    return accountHolder.getId();
                }
            }
        }
        return "N/A";
    }

    public boolean findUser(String userName) {
        for (AccountHolder accountHolder : clients) {
            if (accountHolder.getName() == userName) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", clients=" + clients +
                '}';
    }

    public void addAccountToUser(String userId, String currency) {
        for (AccountHolder client : clients) {
            if (client.getId().equals(userId)) {
                client.addNewAccount(currency);
            }

        }
    }
}
