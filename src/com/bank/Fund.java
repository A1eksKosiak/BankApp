package com.bank;

import java.util.List;

public class Fund extends AccountHolder {

    private String id;
    private List<Account> accounts;

    public Fund(String password,
                String fullName,
                String address,
                String phoneNumber,
                String email,
                String secretQuestion,
                String answerForSecretQuestion) {

        super(password, fullName, address, phoneNumber, email, secretQuestion, answerForSecretQuestion);
    }

    @Override
    public void addNewAccount(Currency currency) {
        if (accounts.size() >= 1){
            return;
        }
            super.addNewAccount(currency);
    }
}
