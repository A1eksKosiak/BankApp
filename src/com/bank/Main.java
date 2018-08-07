package com.bank;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("A1eks");
        bank.addUser("123",
                "Aleks Kosiak",
                "Tallinn",
                "+372 5814 5632",
                "A1eksKosyak@gmail.com",
                "Question",
                "Answer");

        System.out.println("Welcome to " + bank.getBankName() + " bank!");


        //new user
        //new account for user
        //deposit
        //withdraw


    }
}
