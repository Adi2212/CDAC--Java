package com.tester;

import java.util.Scanner;
import com.developers.Emp;

public class TestStatic {
	//static init block
	static {
		System.out.println("TestStatic : static init block");
	}

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        System.out.println("Enter org size");
	        Emp[] emps = new Emp[sc.nextInt()];
	        // Accept emp details from the client & save them
	        for (int i = 0; i < emps.length; i++) {
	            System.out.println("Enter emp details - id nm salary dept_id");
	            emps[i] = new Emp( sc.next(), sc.nextDouble(), sc.nextInt());
	        }
	        // Print sum of salary of all employees.
	        double totalSalary = 0;
	        for (Emp e : emps) // e=emps[0].....
	        {
	            totalSalary += e.getSalary();
	        }
	        System.out.println("Total Salary " + totalSalary);

	        // Lab work -
	        // Accept dept id and salary raise (in %) from the client
	        System.out.println("Enter dept id and salary raise (in %)");
	        int deptId = sc.nextInt();
	        double raise = sc.nextDouble();
	        // Apply it to all emps working in specified dept.
	        for (Emp e : emps) {
	            if (e.getDeptId() == deptId) {
	                double newSalary = e.getSalary() + (e.getSalary() * raise / 100);
	                e.setSalary(newSalary);
	            }
	        }
	        // Display salaries of all emps , after raise
	        System.out.println("Salaries after raise:");
	        for (Emp e : emps) {
	            System.out.println(e.getName() + ": " + e.getSalary());
	        }
	        // Display name of the emp with max salary.
	        double maxSalary = 0;
	        String empName = "";
	        for (Emp e : emps) {
	            if (e.getSalary() > maxSalary) {
	                maxSalary = e.getSalary();
	                empName = e.getName();
	            }
	        }
	        System.out.println("Employee with max salary: " + empName + " with salary " + maxSalary);
	    sc.close();

	}

}
