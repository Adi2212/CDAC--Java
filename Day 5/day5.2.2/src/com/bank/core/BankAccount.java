// BankAccount.java
package com.bank.core;

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

    public void setAccNo(int accNo) {
        this.accNo = accNo;
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

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Amount ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount ₹" + amount + " deposited successfully.");
            return true;
        } else {
            System.out.println("Invalid deposit amount.");
            return false;
        }
    }
}
