package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.bank.Currency.GBP;

public class FundAccountHolderInterface implements AccountHolderInterface {

    private static final int MAX_MONEY_AMOUNT = 1000;

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
        this.name = name;
        this.password = password;
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
        if (accounts.size() == 1000) {
            System.out.println("You have " + accounts.size() + " accounts, please withdraw some money");
            return;
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getBalance() != MAX_MONEY_AMOUNT) {
                double accountBalance = accounts.get(i).getBalance();
                if ((money + accountBalance) <= MAX_MONEY_AMOUNT) {
                    accounts.get(i).addMoneyToAccount(money);
                    return;
                }
                double tempMoney = MAX_MONEY_AMOUNT - accountBalance;
                accounts.get(i).addMoneyToAccount(tempMoney);
                money -= tempMoney;
                addNewAccount(GBP);
            }
        }
    }

    @Override
    public void withdrawMoney(double money) {
        try {
            for (int i = accounts.size() - 1; i >= 0; i--) {
                if (accounts.get(i).getBalance() != 0) {
                    double accountBalance = accounts.get(i).getBalance();
                    if ((money - accountBalance) <= 0) {
                        accounts.get(i).withdrawMoney(money);
                        return;
                    }
                    accounts.get(i).withdrawMoney(accountBalance);
                    money -= accountBalance;
                }
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short on " + e.getAmount());
        }
    }

    public void addNewAccount(Currency currency) {
        Account newAccount = new Account(currency);
        accounts.add(newAccount);
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
