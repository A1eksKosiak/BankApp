package com.bank;

import java.util.ArrayList;

public class Bank {

    private String bankName;

    private ArrayList<User> clients;

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
            if (user.getId() == userID) {
                if (user.findAccountNumber(accountID)) {
                    user.addMoneyToAccount(accountID, amountOfMoney);
                }
            }
        }
    }
}
