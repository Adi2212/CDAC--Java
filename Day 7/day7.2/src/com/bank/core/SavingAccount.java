package com.bank.core;

import com.bank.exception.*;

public class SavingAccount extends BankAccount {
    private static final double INTEREST_RATE;

    static {
        INTEREST_RATE = 3.2;
    }

    public SavingAccount(int accNo, double balance, String name, String phoneNo) {
        super(accNo, balance, name, phoneNo);
    }

    @Override
    public String toString() {
        return "SavingAccount:\n" + super.toString() + ", Interest Rate: " + INTEREST_RATE + "%";
    }

    @Override
    public void withdraw(double amount) throws LowBalanceException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        } else if (getBalance() - amount >= 1000) {
            super.withdraw(amount);
        } else {
            throw new LowBalanceException("Minimum balance ₹1000 must be maintained.");
        }
    }

    public void applyInterest() {
        double interest = (getBalance() * INTEREST_RATE) / 100.0;
        setBalance(getBalance() + interest);
        System.out.println("Interest of ₹" + interest + " applied to account " + getAccNo());
    }
}
