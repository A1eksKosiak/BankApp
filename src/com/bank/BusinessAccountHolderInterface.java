package com.bank;

import java.util.UUID;

import static com.bank.Currency.USD;

public class BusinessAccountHolderInterface implements AccountHolderInterface {

    private static final double FINE = 0.03;

    private Account regular;
    private String id;
    private String name;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;
    private String secretQuestion;
    private String answerForSecretQuestion;

    public BusinessAccountHolderInterface(String name,
                                          String password,
                                          String address,
                                          String phoneNumber,
                                          String email,
                                          String secretQuestion,
                                          String answerForSecretQuestion) {
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.answerForSecretQuestion = answerForSecretQuestion;
        this.regular = new Account(USD);
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public void addMoney(double money) {
        regular.addMoneyToAccount(money);
    }

    @Override
    public void withdrawMoney(double money) {
        try {
            regular.withdrawMoney(money + (money * FINE));
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short on " + e.getAmount());
        }
    }

    @Override
    public String getUniqueIdentifier() {
        return id;
    }

    @Override
    public String toString() {
        return "BusinessAccountHolderInterface{" +
                "regular=" + regular +
                '}';
    }
}
