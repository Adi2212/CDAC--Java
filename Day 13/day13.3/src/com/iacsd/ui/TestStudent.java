package com.iacsd.ui;

import java.util.Scanner;

import com.iacsd.services.SMServices;
import com.iacsd.services.SMServicesImpl;
import com.iacsd.exceptions.StudentException;

public class TestStudent {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            SMServices service = new SMServicesImpl();

            while (true) {
                System.out.println("\n==== Student Admission Management System ====");
                System.out.println("1. Admit Student");
                System.out.println("2. Cancel Admission");
                System.out.println("3. Search Student by Email");
                System.out.println("4. List All Students");
                System.out.println("5. List Students by Course");
                System.out.println("6. Print Course Capacities");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");

                try {
                    switch (sc.nextInt()) {
                        case 1:
                            sc.nextLine(); // clear buffer
                            System.out.print("Enter name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter marks: ");
                            int marks = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter course: ");
                            String course = sc.nextLine();
                            System.out.print("Enter admission date (yyyy-MM-dd): ");
                            String date = sc.nextLine();
                            System.out.println(service.enrollStudent(name, email, marks, course, date));
                            break;

                        case 2:
                            sc.nextLine();
                            System.out.print("Enter email to cancel: ");
                            System.out.println(service.cancelAdmission(sc.nextLine()));
                            break;

                        case 3:
                            sc.nextLine();
                            System.out.print("Enter email to search: ");
                            service.searchStudentByEmail(sc.nextLine());
                            break;

                        case 4:
                            service.listAllStudents();
                            break;

                        case 5:
                            sc.nextLine();
                            System.out.print("Enter course name: ");
                            service.listStudentByCourse(sc.nextLine());
                            break;

                        case 6:
                            service.printCourseCapacities();
                            break;

                        case 7:
                            System.out.println("Exiting system. Goodbye!");
                            return;

                        default:
                            System.out.println("Invalid choice!");
                    }
                } catch (StudentException e) {
                    System.out.println("❌ " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Invalid course name! Please use: CORE_JAVA, DBT, PYTHON, MERN, WEB_JAVA, DEV_OPS");
                }
            }
        }
    }
}
