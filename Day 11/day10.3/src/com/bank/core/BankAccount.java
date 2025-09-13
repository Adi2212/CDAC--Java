package com.bank.core;

import java.time.LocalDate;

public class BankAccount {
	private int accNo;
	private double balance;
	private String name;
	private String phoneNo;
	private AccountType accType;
	private LocalDate birthDate;

	public BankAccount(int accNo, double balance, String name, String phoneNo, AccountType accType,
			LocalDate birthDate) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.name = name;
		this.phoneNo = phoneNo;
		this.accType = accType;
		this.birthDate = birthDate;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccNo() {
		return accNo;
	}

	public double getBalance() {
		return balance;
	}

	public BankAccount(int accNo) {
		super();
		this.accNo = accNo;
	}

	@Override
	public String toString() {
		return "AccNo: " + accNo + ", Balance: ₹" + balance + ", Name: " + name + ", Phone: " + phoneNo
				+ ", account type: " + accType + ", birthdate: " + birthDate;
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
		return this.accNo == ((BankAccount) otherAcc).accNo;
	}
}
