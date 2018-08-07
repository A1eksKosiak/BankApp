package com.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("A1eks");
        Scanner scanner = new Scanner(System.in);
//        AccountHolder user = new Fund("123",
//                "Aleks Kosiak",
//                "Tallinn",
//                "+372 5814 5632",
//                "A1eksKosyak@gmail.com",
//                "Question",
//                "Answer");
//
//        bank.addUser(user);
//        user.addNewAccount("EUR");

        int userOption;
        do {
            System.out.println("Welcome to " + bank.getBankName() + " bank!");
            System.out.println("Choose your action:");
            System.out.println("1 - create new user.");
            System.out.println("2 - add money to account.");
            System.out.println("3 - withdraw money from users account.");
            System.out.println("4 - check total amount of money.");
            System.out.println("5 - print bank");
            System.out.println("6 - open new account");
            System.out.println("0 - exit.");

            userOption = scanner.nextInt();
            switch (userOption) {
                case 1:
                    System.out.println("Choose account holder type");
                    System.out.println("1 - private person");
                    System.out.println("2 - business client");
                    System.out.println("3 - fund");
                    int accountHolderType = scanner.nextInt();
                    System.out.println("Input your password");
                    String password = scanner.next();
                    System.out.println("Input your name");
                    String fullName = scanner.next();
                    System.out.println("Input your address");
                    String address = scanner.next();
                    System.out.println("Input your phone number");
                    String phoneNumber = scanner.next();
                    System.out.println("Input your email");
                    String email = scanner.next();
                    System.out.println("Input your secret question");
                    String secretQuestion = scanner.next();
                    System.out.println("Input your answer to the secret question");
                    String answerForSecretQuestion = scanner.next();
                    switch (accountHolderType) {
                        case 1:
                            User newUser = new User(password,
                                    fullName,
                                    address,
                                    phoneNumber,
                                    email,
                                    secretQuestion,
                                    answerForSecretQuestion);
                            bank.addUser(newUser);
                            newUser.addNewAccount("EUR");
                            break;
                        case 2:
                            Business newBusiness = new Business(password,
                                    fullName,
                                    address,
                                    phoneNumber,
                                    email,
                                    secretQuestion,
                                    answerForSecretQuestion);
                            bank.addUser(newBusiness);
                            newBusiness.addNewAccount("EUR");

                            break;
                        case 3:
                            Fund newFund = new Fund(password,
                                    fullName,
                                    address,
                                    phoneNumber,
                                    email,
                                    secretQuestion,
                                    answerForSecretQuestion);
                            bank.addUser(newFund);
                            newFund.addNewAccount("EUR");
                            break;
                        case 0:
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter userId");
                    String userId = scanner.next();
                    System.out.println("Add account Id");
                    Long accountId = scanner.nextLong();
                    System.out.println("Add amount of money");
                    double money = scanner.nextDouble();
                    bank.addMoneyToUser(userId, accountId, money);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Please enter userID");
                    String idOfUser = scanner.next();
                    System.out.println(bank.totalAmountOfMoney(idOfUser));
                    break;
                case 5:
                    System.out.println(bank);
                    break;
                case 6:
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        } while (true);
    }
}
