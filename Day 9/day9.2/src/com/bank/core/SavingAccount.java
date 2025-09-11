package com.bank.core;

import com.bank.exception.*;
import com.bank.validation.BankValidations;

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
       BankValidations.validAmount(amount);
       BankValidations.validBalanceLimit(getBalance()-amount);
            super.withdraw(amount);
    }

    public void applyInterest() {
        double interest = (getBalance() * INTEREST_RATE) / 100.0;
        setBalance(getBalance() + interest);
        System.out.println("Interest of ₹" + interest + " applied to account " + getAccNo());
    }
}
