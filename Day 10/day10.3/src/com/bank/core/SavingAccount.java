package com.bank.core;

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

	public void applyInterest() {
		double interest = (getBalance() * INTEREST_RATE) / 100.0;
		setBalance(getBalance() + interest);
		System.out.println("Interest of ₹" + interest + " applied to account " + getAccNo());
	}
}
