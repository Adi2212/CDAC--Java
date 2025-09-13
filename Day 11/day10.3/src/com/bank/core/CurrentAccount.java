package com.bank.core;

import java.time.LocalDate;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    private double availableOverdraft;

    public CurrentAccount(int accNo, double balance, String name, String phoneNo,AccountType accType, LocalDate birthDate) {
        super(accNo, balance, name, phoneNo, accType, birthDate);
        this.overdraftLimit = overdraftLimit;
        this.availableOverdraft = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CurrentAccount:\n" + super.toString() + 
               ", Overdraft Limit: ₹" + overdraftLimit +
               ", Available Overdraft: ₹" + availableOverdraft;
    }

    // ✅ No validations here, only logic
    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            super.withdraw(amount);
        } else {
            double deficit = amount - getBalance();
            setBalance(0);
            availableOverdraft -= deficit;
            System.out.println("Amount ₹" + amount + " withdrawn using overdraft.");
        }
    }

    // ✅ No validation here, just handle overdraft recovery
    @Override
    public void deposit(double amount) {
        if (availableOverdraft < overdraftLimit) {
            double overdraftRecovery = overdraftLimit - availableOverdraft;
            if (amount >= overdraftRecovery) {
                amount -= overdraftRecovery;
                availableOverdraft = overdraftLimit;
                System.out.println("Overdraft of ₹" + overdraftRecovery + " repaid.");
            } else {
                availableOverdraft += amount;
                System.out.println("Amount ₹" + amount + " deposited to cover overdraft.");
            }
        }
        super.deposit(amount);
    }

    // ✅ Just update, validation is external
    public void updateOverdraftLimit(double newLimit) {
        this.overdraftLimit = newLimit;
        this.availableOverdraft = newLimit;
        System.out.println("Overdraft limit updated to ₹" + newLimit + " for account " + getAccNo());
    }

    public double getAvailableOverdraft() {
        return availableOverdraft;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
