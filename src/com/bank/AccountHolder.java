package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AccountHolder {

    private String id;
    private String password;
    private String name;
    private String address;
    private List<Account> accounts;
    private String phoneNumber;
    private String email;
    private String secretQuestion;
    private String answerForSecretQuestion;

    public AccountHolder(String password,
                         String name,
                         String address,
                         String phoneNumber,
                         String email,
                         String secretQuestion,
                         String answerForSecretQuestion) {

        this.id = UUID.randomUUID().toString();
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.answerForSecretQuestion = answerForSecretQuestion;
        this.accounts = new ArrayList<>();
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (int i = 0; i < accounts.size(); i++) {
            totalAmount += accounts.get(i).getBalance();
        }
        return totalAmount;
    }

    public void addMoneyToAccount(long accountNumber, double moneyAmount) {
        if (findAccountNumber(accountNumber)) {
            for (Account account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    account.addMoneyToAccount(moneyAmount);
                }
            }
        }
    }

    public boolean findAccountNumber(long accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public void addNewAccount(String currency) {
        Account newAccount = new Account(currency);
        accounts.add(newAccount);
    }

    public void deleteAccount(long accountNumber) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getAnswerForSecretQuestion() {
        return answerForSecretQuestion;
    }

    public void setAnswerForSecretQuestion(String answerForSecretQuestion) {
        this.answerForSecretQuestion = answerForSecretQuestion;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", answerForSecretQuestion='" + answerForSecretQuestion + '\'' +
                '}';
    }
}
