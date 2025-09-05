package com.bank.tester;

import java.util.Scanner;

import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;

public class TestBanking1 {
	public static void main (String[] args ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of account in bank..:");
        BankAccount[] accounts = new BankAccount[sc.nextInt()];
        
        System.out.println("1. Create Saving Account");
        System.out.println("2. Create Current Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Print Account Summary");
        System.out.println("6. Exit");
        int choice;
        int index = 0;
        do {    
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter account number, initial balance, customer name, phone number, interest rate: ");
                    accounts[index++] = new SavingAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter account number, initial balance, customer name, phone number, overdraft limit: ");
                    accounts[index++] = new CurrentAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter account index and deposit amount: ");
                    int accIndex = sc.nextInt();
                    double depositAmount = sc.nextDouble();
                    if (accIndex < index) {
                        accounts[accIndex].deposit(depositAmount);
                    } else {
                        System.out.println("Invalid account index.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account index and withdraw amount: ");
                    accIndex = sc.nextInt();
                    double withdrawAmount = sc.nextDouble();
                    if (accIndex < index) {
                        accounts[accIndex].withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid account index.");
                    }
                    break;
                case 5:
                    for (int i = 0; i < index; i++) {
                        System.out.println("Account " + i + " Summary:");
                        System.out.println(accounts[i].getAccountSummary());
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;     
               
            }
        } while (choice != 5);
        sc.close();
        
	}
}
