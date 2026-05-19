package org.example;

public class BankApp {

    public static void main(String[] args) {

        BankAccount account1 =
                new BankAccount("ACC100", "Alice", 1000);

        SavingsAccount savings1 =
                new SavingsAccount("SAV200",
                        "Bob",
                        2000,
                        5);

        System.out.println("=== Initial Accounts ===");

        account1.displayAccountInfo();

        System.out.println();

        savings1.displayAccountInfo();

        System.out.println("\n=== Deposit Test ===");

        try {

            account1.deposit(500);

            account1.displayAccountInfo();

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Withdraw Test ===");

        try {

            account1.withdraw(300);

            account1.displayAccountInfo();

        } catch (InvalidAmountException | InsufficientFundsException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Invalid Deposit ===");

        try {

            account1.deposit(-100);

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Insufficient Funds ===");

        try {

            account1.withdraw(10000);

        } catch (InvalidAmountException | InsufficientFundsException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Savings Account Interest ===");

        savings1.addInterest();

        savings1.displayAccountInfo();
    }
}
