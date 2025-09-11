package com.bank.tester;

import java.util.Scanner;
import com.bank.services.BankingService;
import com.bank.services.BankingServiceImpl;

public class TestBank {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			BankingService service = new BankingServiceImpl(100);
			boolean exit = false;

			while (!exit) {
				System.out.println("\n=== Banking Menu ===");
				System.out.println("1. Open Saving Account");
				System.out.println("2. Open Current Account");
				System.out.println("3. Display All Accounts");
				System.out.println("4. Deposit");
				System.out.println("5. Withdraw");
				System.out.println("6. Search Account");
				System.out.println("7. Display by Type");
				System.out.println("8. Apply Interest (Savings)");
				System.out.println("9. Update Overdraft Limit");
				System.out.println("0. Exit");
				System.out.print("Choice: ");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.print("Enter accNo, balance, name, phone: ");

						System.out.println(
								service.openSavingAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next()));
						break;

					case 2:
						System.out.print("Enter accNo, balance, name, phone, overdraftLimit: ");
						service.openCurrentAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(),
								sc.nextDouble());
						System.out.println(service.openCurrentAccount(sc.nextInt(), sc.nextDouble(), sc.next(),
								sc.next(), sc.nextDouble()));
						break;

					case 3:
						service.displayAllAccounts();
						break;

					case 4:
						System.out.print("Enter accNo, amount: ");
						service.deposit(sc.nextInt(), sc.nextDouble());
						break;

					case 5:
						System.out.print("Enter accNo, amount: ");
						service.withdraw(sc.nextInt(), sc.nextDouble());
						break;

					case 6:
						System.out.print("Enter accNo: ");
						System.out.println("Found: " + service.findAccount(sc.nextInt()));
						break;

					case 7:
						System.out.print("Enter type (saving/current): ");
						service.displayAccountsByType(sc.next());
						break;

					case 8:
						service.applyInterestToSavings();
						break;

					case 9:
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
