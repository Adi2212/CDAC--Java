package com.bank.services;

import com.bank.core.BankAccount;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.DuplicateAccountException;
import com.bank.exception.InvalidAmountException;
import com.bank.exception.LowBalanceException;

public interface BankingService {
	String openSavingAccount(int accNo, double balance, String name, String phoneNo)
			throws DuplicateAccountException, LowBalanceException;

	String openCurrentAccount(int accNo, double balance, String name, String phoneNo, double overdraftLimit)
			throws DuplicateAccountException;

	void deposit(int accNo, double amount) throws AccountNotFoundException, InvalidAmountException;

	void withdraw(int accNo, double amount)
			throws AccountNotFoundException, InvalidAmountException, LowBalanceException;

	BankAccount findAccount(int accNo) throws AccountNotFoundException;

	void displayAllAccounts();

	void displayAccountsByType(String type);

	void applyInterestToSavings();

	void updateOverdraftLimit(int accNo, double newLimit) throws AccountNotFoundException, InvalidAmountException;
}
