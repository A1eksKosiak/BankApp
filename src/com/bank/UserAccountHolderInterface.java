package com.bank;

import java.util.UUID;

import static com.bank.Currency.EUR;

public class UserAccountHolderInterface implements AccountHolderInterface {

    private static final double FINE = 0.05;

    private Account regular;
    private Account pension;
    private String id;
    private String name;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;
    private String secretQuestion;
    private String answerForSecretQuestion;


    public UserAccountHolderInterface(String name,
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
        this.regular = new Account(EUR);
        this.pension = new Account(EUR);
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getUniqueIdentifier() {
        return id;
    }

    @Override
    public void addMoney(double money) {
        regular.addMoneyToAccount(money / 10 * 9);
        pension.addMoneyToAccount(money / 10);
    }

    @Override
    public void addNewAccount(Currency currency) {
        return;
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
    public String toString() {
        return "UserAccountHolderInterface{" +
                "regular=" + regular +
                ", pension=" + pension +
                '}';
    }
}
