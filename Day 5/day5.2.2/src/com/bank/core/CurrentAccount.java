package com.bank.core;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;      // Maximum overdraft allowed
    private double availableOverdraft;  // Current available overdraft

    public CurrentAccount(int accNo, double balance, String name, String phoneNo, double overdraftLimit) {
        super(accNo, balance, name, phoneNo);
        this.overdraftLimit = overdraftLimit;
        this.availableOverdraft = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CurrentAccount:\n" + super.toString() +
               ", Overdraft Limit: ₹" + overdraftLimit +
               ", Available Overdraft: ₹" + availableOverdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (getBalance() >= amount) {
            super.withdraw(amount);
        } else {
            double deficit = amount - getBalance();
            if (deficit <= availableOverdraft) {
                setBalance(0);
                availableOverdraft -= deficit;
                System.out.println("Amount ₹" + amount + " withdrawn using overdraft.");
            } else {
                System.out.println("Insufficient balance and overdraft limit exceeded.");
            }
        }
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;
        }

        if (availableOverdraft < overdraftLimit) {
            double overdraftRecovery = overdraftLimit - availableOverdraft;
            if (amount >= overdraftRecovery) {
                amount -= overdraftRecovery;
                availableOverdraft = overdraftLimit;
                System.out.println("Overdraft of ₹" + overdraftRecovery + " repaid.");
            } else {
                availableOverdraft += amount;
                System.out.println("Amount ₹" + amount + " deposited to cover overdraft.");
                return true;
            }
        }

        return super.deposit(amount);
    }

    /**
     * Updates the overdraft limit for this account.
     * Resets available overdraft to the new limit.
     */
    public void updateOverdraftLimit(double newLimit) {
        if (newLimit <= 0) {
            System.out.println("Invalid overdraft limit.");
            return;
        }
        this.overdraftLimit = newLimit;
        this.availableOverdraft = newLimit;
        System.out.println("Overdraft limit updated to ₹" + newLimit + " for account " + getAccNo());
    }
}
