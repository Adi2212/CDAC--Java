package com.bank.core;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double balance, String customerName, String phoneNumber, double overdraftLimit) {
        super(accountNumber, balance, customerName, phoneNumber);
        this.overdraftLimit = overdraftLimit;
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount >= -overdraftLimit)) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal failed. Exceeded overdraft limit or invalid amount for Current Account.");
        }
    }

    public void useOverdraftFacility() {
        System.out.println("Current overdraft limit: " + overdraftLimit);
    }
}
