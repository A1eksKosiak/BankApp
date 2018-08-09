package com.bank;

import com.bank.Old.Fund;

import java.util.Scanner;

import static com.bank.Currency.GBP;

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
                    withdrawMoneyFromAccount(bank);
                    break;
                case 4:
                    checkTotalAmountOfMoney(bank);
                    break;
                case 5:
                    System.out.println(bank);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    private static void withdrawMoneyFromAccount(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your user ID");
        String userId = scanner.next();
        System.out.println("Add amount of money to withdraw");
        double money = scanner.nextDouble();
        bank.withdrawMoneyFromUser(userId, money);
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
        System.out.println("Add amount of money");
        double money = scanner.nextDouble();
        bank.addMoneyToUser(userId, money);
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
        String name = scanner.next();
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
            AccountHolderInterface newUser = new UserAccountHolderInterface(
                    name,
                    password,
                    address,
                    phoneNumber,
                    email,
                    secretQuestion,
                    answerForSecretQuestion);
            bank.addUser(newUser);
        } else if (caseNumber == 2) {
            AccountHolderInterface newBusiness = new BusinessAccountHolderInterface(
                    name,
                    password,
                    address,
                    phoneNumber,
                    email,
                    secretQuestion,
                    answerForSecretQuestion);
            bank.addUser(newBusiness);
        } else if (caseNumber == 3) {
            AccountHolderInterface newFund = new FundAccountHolderInterface(password,
                    name,
                    address,
                    phoneNumber,
                    email,
                    secretQuestion,
                    answerForSecretQuestion);
            bank.addUser(newFund);
            bank.addAccountToUser(newFund.getUniqueIdentifier(),GBP);
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
        System.out.println("0 - exit.");
    }

}
