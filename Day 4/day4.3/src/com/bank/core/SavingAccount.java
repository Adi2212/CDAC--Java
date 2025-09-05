package com.bank.core;

public class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(int accountNumber, double balance, String customerName, String phoneNumber, double interestRate) {
        super(accountNumber, balance, customerName, phoneNumber);
        this.interestRate = interestRate;
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount for Saving Account.");
           
        }
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Applied interest: " + interest);
    }
}
