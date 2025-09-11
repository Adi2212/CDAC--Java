package com.bank.services;

import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.exception.*;

public class BankValidations {

    // duplicate account check
    public static void validAccountNo(BankAccount existing, BankAccount newAcc) throws DuplicateAccountException {
        if (existing.equals(newAcc)) {
            throw new DuplicateAccountException("Duplicate account number: " + newAcc.getAccNo());
        }
    }

    // min balance rule for saving account
    public static void validBalanceLimit(double balance) throws LowBalanceException {
        final double MIN_BALANCE = 1000.0;
        if (balance < MIN_BALANCE) {
            throw new LowBalanceException("Saving Account requires minimum balance of ₹" + MIN_BALANCE);
        }
    }

    // deposit validation
    public static void validDeposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
    }

    // withdraw validation
    public static void validWithdraw(BankAccount acc, double amount)
            throws InvalidAmountException, LowBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        if (acc instanceof CurrentAccount) {
            CurrentAccount curr = (CurrentAccount) acc;
            double totalAvailable = curr.getBalance() + curr.getAvailableOverdraft();
            if (amount > totalAvailable) {
                throw new LowBalanceException("Withdrawal exceeds balance + overdraft limit.");
            }
        } else {
            if (acc.getBalance() < amount) {
                throw new LowBalanceException("Insufficient balance for withdrawal.");
            }
        }
    }

    // overdraft limit update rule
    public static void validOverdraftLimit(double newLimit) throws InvalidAmountException {
        if (newLimit <= 0) {
            throw new InvalidAmountException("Overdraft limit must be positive.");
        }
    }
}
