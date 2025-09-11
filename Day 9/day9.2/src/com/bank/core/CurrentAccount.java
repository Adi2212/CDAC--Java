package com.bank.core;

import com.bank.exception.InvalidAmountException;
import com.bank.exception.LowBalanceException;
import com.bank.validation.BankValidations;

public class CurrentAccount extends BankAccount {
	private double overdraftLimit;
	private double availableOverdraft;

	public CurrentAccount(int accNo, double balance, String name, String phoneNo, double overdraftLimit) {
		super(accNo, balance, name, phoneNo);
		this.overdraftLimit = overdraftLimit;
		this.availableOverdraft = overdraftLimit;
	}

	@Override
	public String toString() {
		return "CurrentAccount:\n" + super.toString() + ", Overdraft Limit: ₹" + overdraftLimit
				+ ", Available Overdraft: ₹" + availableOverdraft;
	}

	@Override
	public void withdraw(double amount) throws LowBalanceException, InvalidAmountException {
		BankValidations.validAmount(amount);
		if (getBalance() >= amount) {
			super.withdraw(amount);
		} else {
			double deficit = amount - getBalance();
			System.out.println("it 9sd");
			BankValidations.validOverdraftLimit(deficit, availableOverdraft);
				setBalance(0);
				availableOverdraft -= deficit;
				System.out.println("Amount ₹" + amount + " withdrawn using overdraft.");
			
		}
	}

	@Override
	public boolean deposit(double amount) throws InvalidAmountException {
		BankValidations.validAmount(amount);

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

	public void updateOverdraftLimit(double newLimit) throws InvalidAmountException {
		if (newLimit <= 0) {
			throw new InvalidAmountException("Overdraft limit must be positive.");
		}
		this.overdraftLimit = newLimit;
		this.availableOverdraft = newLimit;
		System.out.println("Overdraft limit updated to ₹" + newLimit + " for account " + getAccNo());
	}
}
