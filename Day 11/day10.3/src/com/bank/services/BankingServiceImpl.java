package com.bank.services;

import java.util.ArrayList;
import java.util.List;

import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.DuplicateAccountException;
import com.bank.exception.InvalidAccountTypeException;
import com.bank.exception.InvalidAmountException;
import com.bank.exception.LowBalanceException;

public class BankingServiceImpl implements BankingService {
    private ArrayList<BankAccount> bankAccounts;

    public BankingServiceImpl() {
        // capacity is optional, just initializes underlying array
        bankAccounts = new ArrayList<>();
    }

    @Override
    public String openAccount(int accNo, double balance, String name, String phoneNo, String accType, String birthDate,double overdraftLimit)
			throws DuplicateAccountException, LowBalanceException, InvalidAccountTypeException{
    	bankAccounts.add(BankValidations.valideAllInput(accNo, balance, name, phoneNo, accType, birthDate,overdraftLimit, bankAccounts));
    	
    	
    	return "";
    }

    @Override
    public void withdraw(int accNo, double amount)
            throws AccountNotFoundException, InvalidAmountException, LowBalanceException {
        BankAccount acc = findAccount(accNo);
        BankValidations.validWithdraw(acc, amount);
        acc.withdraw(amount);
    }

    @Override
    public void deposit(int accNo, double amount)
            throws AccountNotFoundException, InvalidAmountException {
        BankAccount acc = findAccount(accNo);
        BankValidations.validDeposit(amount);
        acc.deposit(amount);
    }

    @Override
    public void updateOverdraftLimit(int accNo, double newLimit)
            throws AccountNotFoundException, InvalidAmountException {
        BankAccount acc = findAccount(accNo);
        if (!(acc instanceof CurrentAccount)) {
            throw new InvalidAmountException("Account " + accNo + " is not a Current Account.");
        }
        BankValidations.validOverdraftLimit(newLimit);
        ((CurrentAccount) acc).updateOverdraftLimit(newLimit);
    }

    @Override
    public BankAccount findAccount(int accNo) throws AccountNotFoundException {
        for (BankAccount acc : bankAccounts) {
            if (acc.getAccNo() == accNo) {
                return acc;
            }
        }
        throw new AccountNotFoundException("Account number " + accNo + " not found.");
    }

    @Override
    public void displayAllAccounts() {
        if (bankAccounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for (BankAccount acc : bankAccounts) {
            System.out.println(acc);
        }
    }

    @Override
    public void displayAccountsByType(String type) {
        boolean found = false;
        for (BankAccount acc : bankAccounts) {
            if ("saving".equalsIgnoreCase(type) && acc instanceof SavingAccount) {
                System.out.println(acc);
                found = true;
            } else if ("current".equalsIgnoreCase(type) && acc instanceof CurrentAccount) {
                System.out.println(acc);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No accounts of type " + type + " found.");
        }
    }

    @Override
    public void applyInterestToSavings() {
        boolean applied = false;
        for (BankAccount acc : bankAccounts) {
            if (acc instanceof SavingAccount) {
                ((SavingAccount) acc).applyInterest();
                applied = true;
            }
        }
        if (!applied) {
            System.out.println("No Saving Accounts found.");
        }
    }
}
