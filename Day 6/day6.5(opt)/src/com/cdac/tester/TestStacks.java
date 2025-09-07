package com.cdac.tester;

import java.util.Scanner;
import com.cdac.core.*;

public class TestStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = null; // polymorphic reference

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1 - Choose Fixed Stack");
            System.out.println("2 - Choose Growable Stack");
            System.out.println("3 - Push data");
            System.out.println("4 - Pop data");
            System.out.println("5 - Exit");
            System.out.print("Enter choice: ");

            switch (sc.nextInt()) {
            case 1:
                if (stack == null) {
                    stack = new FixedStack();
                    System.out.println("Fixed Stack selected.");
                } else {
                    System.out.println("Stack already chosen!");
                }
                break;

            case 2:
                if (stack == null) {
                    stack = new GrowableStack();
                    System.out.println("Growable Stack selected.");
                } else {
                    System.out.println("Stack already chosen!");
                }
                break;

            case 3:
                if (stack == null) {
                    System.out.println("No stack chosen yet!");
                } else {
                    System.out.println("Enter Customer details: id name address");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String address = sc.next();
                    stack.push(new Customer(id, name, address));
                }
                break;

            case 4:
                if (stack == null) {
                    System.out.println("No stack chosen yet!");
                } else {
                    Customer c = stack.pop();
                    if (c != null) {
                        System.out.println("Popped: " + c);
                    }
                }
                break;

            case 5:
                exit = true;
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
