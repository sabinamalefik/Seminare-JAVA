package org.example;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber,
                          String ownerName,
                          double balance,
                          double interestRate) {

        super(accountNumber, ownerName, balance);

        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest() {

        double interest = getBalance() * interestRate / 100;

        try {
            deposit(interest);

            System.out.println("Interest added: " + interest);

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());
        }
    }

    @Override
    public void displayAccountInfo() {

        super.displayAccountInfo();

        System.out.println("Interest Rate: " + interestRate + "%");
    }
}