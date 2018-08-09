package com.bank.Old;

public class User extends AccountHolder {

    final private static int FINE = 5;

    public User(String password,
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
