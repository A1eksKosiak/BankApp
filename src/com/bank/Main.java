package com.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("A1eks");
        Scanner scanner = new Scanner(System.in);
        User user = new User("123",
                "Aleks Kosiak",
                "Tallinn",
                "+372 5814 5632",
                "A1eksKosyak@gmail.com",
                "Question",
                "Answer");

        bank.addUser(user);
        user.addNewAccount("EUR");

        int userOption;
        do {
            System.out.println("Welcome to " + bank.getBankName() + " bank!");
            System.out.println("Your current user is: " + bank.getUserID("Aleks Kosiak"));
//        System.out.println("Your new bank account is: " +;
            System.out.println("Choose your action:");
            System.out.println("1 - create new user;");
            System.out.println("2 - add money to selected account of your user;");
            System.out.println("3 - withdraw money from users account;");
            System.out.println("4 - check total amount of money of your user");
            System.out.println("0 - exit");

            System.out.println(bank);
            userOption = scanner.nextInt();
            switch (userOption) {
                case 1:
                    break;
                case 2:
                    System.out.println("Enter userId");
                    String userId = scanner.next();
                    System.out.println("Add account Id");
                    Long accountId = scanner.nextLong();
                    System.out.println("Add amount of money");
                    double money = scanner.nextDouble();
                    bank.addMoneyToUser(userId, accountId, money);
                    System.out.println(user.totalAmount());
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Please enter userID");
                    String idOfUser = scanner.next();
                    System.out.println(bank.totalAmountOfMoney(idOfUser));
                    break;
                default:
                    break;
            }
        } while (userOption != 0);

    }
}
