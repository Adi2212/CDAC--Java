package com.bank.tester;

import java.util.Scanner;
import com.bank.services.BankingService;
import com.bank.services.BankingServiceImpl;

public class TestBank {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			BankingService service = new BankingServiceImpl();
			boolean exit = false;

			while (!exit) {
				System.out.println("\n=== Banking Menu ===");
				System.out.println("1. Open Saving Account");
				System.out.println("2. Display All Accounts");
				System.out.println("3. Deposit");
				System.out.println("4. Withdraw");
				System.out.println("5. Search Account");
				System.out.println("6. Display by Type");
				System.out.println("7. Apply Interest (Savings)");
				System.out.println("8. Update Overdraft Limit");
				System.out.println("0. Exit");
				System.out.print("Choice: ");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.print("Enter accNo, balance, name, phone, overdraftLimit(if saving account overdraft is 0 ): ");
						System.out.println(service.openAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.nextDouble()));
						break;
						
					case 2:
						service.displayAllAccounts();
						break;

					case 3:
						System.out.print("Enter accNo, amount: ");
						service.deposit(sc.nextInt(), sc.nextDouble());
						break;

					case 4:
						System.out.print("Enter accNo, amount: ");
						service.withdraw(sc.nextInt(), sc.nextDouble());
						break;

					case 5:
						System.out.print("Enter accNo: ");
						System.out.println("Found: " + service.findAccount(sc.nextInt()));
						break;

					case 6:
						System.out.print("Enter type (saving/current): ");
						service.displayAccountsByType(sc.next());
						break;

					case 7:
						service.applyInterestToSavings();
						break;

					case 8:
						System.out.print("Enter accNo, newLimit: ");
						service.updateOverdraftLimit(sc.nextInt(), sc.nextDouble());
						break;

					case 0:
						exit = true;
						System.out.println("Exiting... Thanks!");
						break;
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					sc.nextLine(); // clear input buffer
				}
			}
		}
	}
}
