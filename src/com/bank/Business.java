package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Business extends AccountHolder {

    private String id;
    private List<Account> accounts;

    public Business(String password,
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

}
