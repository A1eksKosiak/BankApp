package com.bank;

import java.util.List;

public class Business extends AccountHolder {

    final private static int FINE = 3;

    public Business(String password,
                    String fullName,
                    String address,
                    String phoneNumber,
                    String email,
                    String secretQuestion,
                    String answerForSecretQuestion) {

        super(password, fullName, address, phoneNumber, email, secretQuestion, answerForSecretQuestion);
    }

    @Override
    public void addMoneyToAccount(long accountNumber, double moneyAmount) {
        moneyAmount = (moneyAmount / 100) * (100 - FINE);
        super.addMoneyToAccount(accountNumber, moneyAmount);
    }
}
