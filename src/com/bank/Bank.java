package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String bankName;

    private List<User> clients;

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
        User newUser = new User(password, fullName, address, phoneNumber, email, secretQuestion, answerForSecretQuestion);
        clients.add(newUser);
    }

    public void addUser(User user) {
        clients.add(user);
    }

    public Double totalAmountOfMoney(String userID) {
        for (User user : clients) {
            if (user.getId().equals(userID)) {
                return user.totalAmount();
            }
        }
        return null;
    }

    public double totalAmountOfMoney(User user) {
        return user.totalAmount();
    }

    public void addMoneyToUser(String userID, long accountID, double amountOfMoney) {
        for (User user : clients) {
            if (user.getId().equals(userID)) {
                user.addMoneyToAccount(accountID, amountOfMoney);
                return;
            }
        }
    }

    public String getUserID(String userName) {
        if (findUser(userName)) {
            for (User user : clients) {
                if (user.getFullName() == userName) {
                    return user.getId();
                }
            }
        }
        return "N/A";
    }

    public boolean findUser(String userName) {
        for (User user : clients) {
            if (user.getFullName() == userName) {
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
}
