package com.ecommerce.tester;

import java.util.Scanner;

import com.ecommerce.core.Category;
import com.ecommerce.service.ECommerceService;
import com.ecommerce.service.ECommerceServiceImpl;

public class ECommerceTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ECommerceService service = new ECommerceServiceImpl();

		boolean exit = false;
		while (!exit) {
			System.out.println("\n=== E-Commerce Menu ===");
			System.out.println("1. Add Product");
			System.out.println("2. Display All Products");
			System.out.println("3. Register Customer");
			System.out.println("4. Customer Login");
			System.out.println("5. Place Order");
			System.out.println("6. View Customer Orders");
			System.out.println("7. Cancel Order");
			System.out.println("8. Exit");
			System.out.print("Choose option: ");

			try {
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					service.addProduct("Notebook", 50.0, 100, "STATIONERY");
//					System.out.print("Enter product name: ");
//					String name = sc.nextLine();
//					System.out.print("Enter category (STATIONERY, TEXTBOOKS, ARTS_CRAFTS): ");
//					String category = sc.next().toUpperCase();
//					System.out.print("Enter price: ");
//					double price = sc.nextDouble();
//					System.out.print("Enter stock: ");
//					int stock = sc.nextInt();
//					service.addProduct(name, price, stock, category);
					break;

				case 2:
					service.displayProducts();
					break;

				case 3:
					service.registerCustomer("Aditya", "aditya@example.com", "pass123");
//					System.out.print("Enter name: ");
//					String cname = sc.nextLine();
//					System.out.print("Enter email: ");
//					String email = sc.nextLine();
//					System.out.print("Enter password: ");
//					String pass = sc.nextLine();
//					service.registerCustomer(cname, email, pass);
					break;

				case 4:
					System.out.print("Enter email: ");
					String lemail = sc.nextLine();
					System.out.print("Enter password: ");
					String lpass = sc.nextLine();
					service.login(lemail, lpass);
					System.out.println("Login successful.");
					break;

				case 5:
					System.out.print("Enter productId: ");
					int pid = sc.nextInt();
					System.out.print("Enter quantity: ");
					int qty = sc.nextInt();
					service.placeOrder(pid, qty);
					break;

				case 6:
					service.viewOrders();
					break;

				case 7:
					System.out.print("Enter OrderId to cancel: ");
					int oid = sc.nextInt();
					service.cancelOrder(oid);
					break;

				case 8:
					exit = true;
					break;

				default:
					System.out.println("Invalid option.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine(); // clear buffer
			}
		}
		sc.close();
		System.out.println("Exited.");
	}
}
