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

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

   

    @Override
    public String toString() {
        return "AccNo: " + accNo + ", Balance: ₹" + balance + ", Name: " + name + ", Phone: " + phoneNo;
    }

    // ✅ No validation logic here, just update balance
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount ₹" + amount + " deposited successfully.");
    }

    // ✅ No validation logic here, just update balance
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Amount ₹" + amount + " withdrawn successfully.");
    }

    @Override
    public boolean equals(Object otherAcc) {
        return this.getAccNo() == ((BankAccount) otherAcc).getAccNo();
    }
}
