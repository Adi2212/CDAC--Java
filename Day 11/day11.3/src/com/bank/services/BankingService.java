package com.bank.services;

import java.util.List;

import com.bank.core.BankAccount;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.DuplicateAccountException;
import com.bank.exception.InvalidAccountTypeException;
import com.bank.exception.InvalidAmountException;
import com.bank.exception.LowBalanceException;

public interface BankingService {
	String openAccount(int accNo, double balance, String name, String phoneNo, String accType, String birthDate,double overdraftLimit)
			throws DuplicateAccountException, LowBalanceException, InvalidAccountTypeException;

	

	void deposit(int accNo, double amount) throws AccountNotFoundException, InvalidAmountException, LowBalanceException;

	void withdraw(int accNo, double amount)
			throws AccountNotFoundException, InvalidAmountException, LowBalanceException;

	BankAccount findAccount(int accNo) throws AccountNotFoundException;

	void displayAllAccounts();

	void displayAccountsByType(String type);

	void applyInterestToSavings();

	void updateOverdraftLimit(int accNo, double newLimit) throws AccountNotFoundException, InvalidAmountException;
}
