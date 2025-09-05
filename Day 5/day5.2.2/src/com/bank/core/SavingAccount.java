// SavingAccount.java
package com.bank.core;

public class SavingAccount extends BankAccount {
    private static final double INTEREST_RATE;

    static {
        INTEREST_RATE = 3.2; // Annual interest rate in percentage
    }

    public SavingAccount(int accNo, double balance, String name, String phoneNo) {
        super(accNo, balance, name, phoneNo);
    }

    @Override
    public String toString() {
        return "SavingAccount:\n" + super.toString() + ", Interest Rate: " + INTEREST_RATE + "%";
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (getBalance() - amount >= 1000) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance. Minimum ₹1000 must be maintained.");
        }
    }

    /**
     * Applies interest to the saving account balance.
     * For simplicity, applies annual interest as a one-time addition.
     */
    public void applyInterest() {
        double interest = (getBalance() * INTEREST_RATE) / 100.0;
        setBalance(getBalance() + interest);
        System.out.println("Interest of ₹" + interest + " applied to account " + getAccNo());
    }
}
