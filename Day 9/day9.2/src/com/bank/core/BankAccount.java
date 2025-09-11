package com.bank.core;

import com.bank.exception.*;
import com.bank.validation.BankValidations;

public class BankAccount {
    private int accNo;
    private double balance;
    private String name;
    private String phoneNo;

    public BankAccount(int accNo, double balance, String name, String phoneNo) {
        this.accNo = accNo;
        this.balance = balance;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccNo: " + accNo + ", Balance: ₹" + balance + ", Name: " + name + ", Phone: " + phoneNo;
    }

    public void withdraw(double amount) throws LowBalanceException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount ₹" + amount + " withdrawn successfully.");
        } else {
            throw new LowBalanceException("Insufficient balance for withdrawal.");
        }
    }
@Override
    public boolean equals(Object otherAcc) {
	return this.accNo==((BankAccount)otherAcc).accNo;
    }
    public boolean deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Amount ₹" + amount + " deposited successfully.");
        return true;
    }
}
