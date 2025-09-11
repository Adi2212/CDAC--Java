package com.bank.validation;

import com.bank.core.BankAccount;
import com.bank.exception.DuplicateAccountException;
import com.bank.exception.InvalidAmountException;
import com.bank.exception.LowBalanceException;

public class BankValidations {
	public static final int  MIN_SAVING_ACCOUNT_BALANCE;
	static {
		MIN_SAVING_ACCOUNT_BALANCE=1000;
	}
	
	public static void validAccountNo(Object current, Object other) throws DuplicateAccountException {
		if (current.equals(other))
			throw new DuplicateAccountException("Account number  already exists!");
	}
	
	public static void validAmount(double amount) throws InvalidAmountException {
		if(amount<0)
		 throw new InvalidAmountException("Withdrawal amount must be positive.");
	}
	
	public static void validBalanceLimit(double amount) throws LowBalanceException {
		if(amount < MIN_SAVING_ACCOUNT_BALANCE)
		 throw new LowBalanceException("Minimum balance ₹1000 must be maintained.");
	}
	
	public static void validOverdraftLimit(double deficit, double availableOverdraft) throws LowBalanceException {
		if (deficit >= availableOverdraft) {
			System.out.println(deficit+ "    "+availableOverdraft);
			throw new LowBalanceException("Overdraft limit exceeded.");
		}
	}
}
