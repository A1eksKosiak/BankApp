package com.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("A1eks");
        Scanner scanner = new Scanner(System.in);

        int userOption;
        while (true) {
            greetingMessage(bank);
            userOption = scanner.nextInt();
            switch (userOption) {
                case 1:
                    createNewAccountHolder(bank);
                    break;
                case 2:
                    addMoneyToAccount(bank);
                    break;
                case 3:
                    break;
                case 4:
                    checkTotalAmountOfMoney(bank);
                    break;
                case 5:
                    System.out.println(bank);
                    break;
                case 6:
                    System.out.println("Input your user ID");
                    String userId = scanner.next();
//                    bank.addAccountToUser(userId, "EUR");
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    private static void checkTotalAmountOfMoney(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter userID");
        String idOfUser = scanner.next();
        System.out.println(bank.totalAmountOfMoney(idOfUser));
    }

    private static void addMoneyToAccount(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter userId");
        String userId = scanner.next();
        System.out.println("Add account Id");
        Long accountId = scanner.nextLong();
        System.out.println("Add amount of money");
        double money = scanner.nextDouble();
        bank.addMoneyToUser(userId, accountId, money);
    }

    private static void createNewAccountHolder(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose account holder type");
        System.out.println("1 - private person");
        System.out.println("2 - business client");
        System.out.println("3 - fund");
        System.out.println("0 - return");
        int accountHolderType = scanner.nextInt();
        switch (accountHolderType) {
            case 1:
                generateNewAccountHolder(bank, 1);
                break;
            case 2:
                generateNewAccountHolder(bank, 2);
                break;
            case 3:
                generateNewAccountHolder(bank, 3);
                break;
            case 0:
                return;
            default:
                break;
        }
    }

    private static void generateNewAccountHolder(Bank bank, int caseNumber) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your name");
        String fullName = scanner.next();
        System.out.println("Input your password");
        String password = scanner.next();
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
        if (caseNumber == 1) {
            User newUser = new User(password,
                    fullName,
                    address,
                    phoneNumber,
                    email,
                    secretQuestion,
                    answerForSecretQuestion);
            bank.addUser(newUser);
            newUser.addNewAccount("EUR");
        } else if (caseNumber == 2) {
            Business newBusiness = new Business(password,
                    fullName,
                    address,
                    phoneNumber,
                    email,
                    secretQuestion,
                    answerForSecretQuestion);
            bank.addUser(newBusiness);
            newBusiness.addNewAccount("EUR");
        } else if (caseNumber == 3) {
            Fund newFund = new Fund(password,
                    fullName,
                    address,
                    phoneNumber,
                    email,
                    secretQuestion,
                    answerForSecretQuestion);
            bank.addUser(newFund);
            newFund.addNewAccount("EUR");
        }
    }

    private static void greetingMessage(Bank bank) {
        System.out.println("Welcome to " + bank.getBankName() + " bank!");
        System.out.println("Choose your action:");
        System.out.println("1 - create new user.");
        System.out.println("2 - add money to account.");
        System.out.println("3 - withdraw money from users account.");
        System.out.println("4 - check total amount of money.");
        System.out.println("5 - print bank");
        System.out.println("6 - open new account");
        System.out.println("0 - exit.");
    }

}
