package com.bank.services;

import java.time.LocalDate;
import java.util.List;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.bank.exception.*;

public class BankValidations {

	public static BankAccount valideAllInput(int accNo, double balance, String name, String phoneNo, String accType,
			String birthDate,double overdraftLimit, List<BankAccount> bankAccounts)
			throws DuplicateAccountException, LowBalanceException, InvalidAccountTypeException {
		validAccountNo(accNo, bankAccounts);
		AccountType choosenType = validAccountType(accType);
		validBalanceLimit(balance,choosenType);
		LocalDate date = LocalDate.parse(birthDate);
		if(choosenType.equals(AccountType.SAVING)) {
			return new SavingAccount(accNo, balance, name, phoneNo, choosenType, date);
		}else {
		return new CurrentAccount(accNo, balance, name, phoneNo, choosenType, date,overdraftLimit);
		}
	}
	

	private static AccountType validAccountType(String accType) throws InvalidAccountTypeException {
		for (AccountType At : AccountType.values()) {
			if (At.name().equals(accType.toUpperCase())) {
				return At;
			}
		}
		throw new InvalidAccountTypeException("Invalid Account type: SAVING, CURRENT");
	}

	// duplicate account check
	public static void validAccountNo(int accNo, List<BankAccount> bankAccounts) throws DuplicateAccountException {
		BankAccount temp = new BankAccount(accNo);
		if (bankAccounts.contains(temp)) {
			throw new DuplicateAccountException("Duplicate account number: " + accNo);
		}
	}

	// min balance rule for saving account
	public static void validBalanceLimit(double balance, AccountType accType) throws LowBalanceException {
	    final double MIN_BALANCE = 1000.0;
	    if (accType.equals(AccountType.SAVING)  && balance < MIN_BALANCE) {
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
