package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FundAccountHolderInterface implements AccountHolderInterface {

    private List<Account> accounts;
    private String id;
    private String name;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;
    private String secretQuestion;
    private String answerForSecretQuestion;


    public FundAccountHolderInterface(String name,
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
        this.accounts = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public void addMoney(double money) {


    }

    @Override
    public void withdrawMoney(double money) {
//        try {
//            regular.withdrawMoney(money);
//        } catch (InsufficientFundsException e) {
//            System.out.println("Sorry, but you are short on " + e.getAmount());
//        }
    }

    @Override
    public String getUniqueIdentifier() {
        return id;
    }

    @Override
    public String toString() {
        return "FundAccountHolderInterface{" +
                "accounts=" + accounts +
                '}';
    }
}
