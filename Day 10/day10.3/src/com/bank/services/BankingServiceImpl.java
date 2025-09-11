package com.bank.services;

import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.DuplicateAccountException;
import com.bank.exception.InvalidAmountException;
import com.bank.exception.LowBalanceException;

public class BankingServiceImpl implements BankingService {
    private BankAccount[] customers;
    private int count;

    public BankingServiceImpl(int capacity) {
        customers = new BankAccount[capacity];
        count = 0;
    }

    @Override
    public String openSavingAccount(int accNo, double balance, String name, String phoneNo)
            throws DuplicateAccountException, LowBalanceException {
        BankAccount newAcc = new SavingAccount(accNo, balance, name, phoneNo);

        for (BankAccount acc : customers) {
            if (acc != null) {
                BankValidations.validAccountNo(acc, newAcc);
            }
        }
        BankValidations.validBalanceLimit(balance);

        customers[count++] = newAcc;
        return "Saving Account created successfully";
    }

    @Override
    public String openCurrentAccount(int accNo, double balance, String name, String phoneNo, double overdraftLimit)
            throws DuplicateAccountException {
        BankAccount newAcc = new CurrentAccount(accNo, balance, name, phoneNo, overdraftLimit);

        for (BankAccount acc : customers) {
            if (acc != null) {
                BankValidations.validAccountNo(acc, newAcc);
            }
        }

        customers[count++] = newAcc;
        return "Current Account created successfully";
    }

    @Override
    public void withdraw(int accNo, double amount)
            throws AccountNotFoundException, InvalidAmountException, LowBalanceException {
        BankAccount acc = findAccount(accNo);
        BankValidations.validWithdraw(acc, amount); // ✅ validation here
        acc.withdraw(amount); // ✅ safe execution
    }

    @Override
    public void deposit(int accNo, double amount) throws AccountNotFoundException, InvalidAmountException {
        BankAccount acc = findAccount(accNo);
        BankValidations.validDeposit(amount); // ✅ validation here
        acc.deposit(amount);
    }

    @Override
    public void updateOverdraftLimit(int accNo, double newLimit)
            throws AccountNotFoundException, InvalidAmountException {
        BankAccount acc = findAccount(accNo);
        if (!(acc instanceof CurrentAccount)) {
            throw new InvalidAmountException("Account " + accNo + " is not a Current Account.");
        }
        BankValidations.validOverdraftLimit(newLimit); // ✅ validation
        ((CurrentAccount) acc).updateOverdraftLimit(newLimit);
    }



    @Override
    public BankAccount findAccount(int accNo) throws AccountNotFoundException {
        for (BankAccount acc : customers) {
            if (acc != null && acc.getAccNo() == accNo) {
                return acc;
            }
        }
        throw new AccountNotFoundException("Account number " + accNo + " not found.");
    }

    @Override
    public void displayAllAccounts() {
        if (count == 0) {
            System.out.println("No accounts available.");
            return;
        }
        for (BankAccount acc : customers) {
            if (acc != null) {
                System.out.println(acc);
            }
        }
    }

    @Override
    public void displayAccountsByType(String type) {
        boolean found = false;
        for (BankAccount acc : customers) {
            if (acc != null) {
                if ("saving".equalsIgnoreCase(type) && acc instanceof SavingAccount) {
                    System.out.println(acc);
                    found = true;
                } else if ("current".equalsIgnoreCase(type) && acc instanceof CurrentAccount) {
                    System.out.println(acc);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No accounts of type " + type + " found.");
        }
    }

    @Override
    public void applyInterestToSavings() {
        boolean applied = false;
        for (BankAccount acc : customers) {
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
