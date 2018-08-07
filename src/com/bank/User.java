package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends AccountHolder {

    final private static int FINE = 5;

    private String id;
    private List<Account> accounts;

    public User(String password,
                String fullName,
                String address,
                String phoneNumber,
                String email,
                String secretQuestion,
                String answerForSecretQuestion) {

        super(password, fullName, address, phoneNumber, email, secretQuestion, answerForSecretQuestion);
        this.id = UUID.randomUUID().toString();
        this.accounts = new ArrayList<>();
    }

    @Override
    public void addMoneyToAccount(long accountNumber, double moneyAmount) {
        moneyAmount = (moneyAmount / 100) * (100 - FINE);
        super.addMoneyToAccount(accountNumber, moneyAmount);
    }
}
