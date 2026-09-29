package com.example.quarter2.PracticalExam.Paguirigan;

import java.util.Scanner;

public class LibraryMenu {

    private static final double FINE_AMOUNT = 15.0;

    private final String[] catalog = {
            "Java Programming Basics",
            "Data Structures Made Easy",
            "Introduction to Algorithms",
            "Clean Code",
            "Database Systems"
    };
    private final boolean[] borrowed = new boolean[catalog.length];

    private double outstandingFine = 0;

    public void start(Scanner scanner) {
        boolean running = true;

        while (running) {
            displayMenu();

            if (!scanner.hasNextLine()) {
                System.out.println("No more input. Exiting system.");
                break;
            }

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    borrowBook();
                    break;
                case "2":
                    payFines(scanner);
                    break;
                case "3":
                    System.out.println("Thank you for using the Library Kiosk. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== LIBRARY KIOSK =====");
        System.out.println("[1] Borrow Book");
        System.out.println("[2] Pay Fines");
        System.out.println("[3] Exit");
        System.out.print("Enter choice: ");
    }

    private void borrowBook() {
        for (int i = 0; i < catalog.length; i++) {
            if (!borrowed[i]) {
                borrowed[i] = true;
                outstandingFine += FINE_AMOUNT;
                System.out.println("You borrowed: \"" + catalog[i] + "\"");
                System.out.printf("A fine of %.2f has been added to your account.%n", FINE_AMOUNT);
                System.out.printf("Total outstanding fine: %.2f%n", outstandingFine);
                return;
            }
        }
        System.out.println("Sorry, all books are currently borrowed.");
    }

    private void payFines(Scanner scanner) {
        if (outstandingFine <= 0) {
            System.out.println("You have no outstanding fines.");
            return;
        }

        System.out.printf("Outstanding fine: %.2f%n", outstandingFine);
        System.out.print("Enter payment amount: ");

        if (!scanner.hasNextLine()) {
            System.out.println("No payment entered.");
            return;
        }

        double payment;
        try {
            payment = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number.");
            return;
        }

        if (payment < outstandingFine) {
            System.out.printf("Insufficient payment. You still need %.2f more.%n",
                    outstandingFine - payment);
        } else {
            double change = payment - outstandingFine;
            System.out.println("Payment successful. Fines cleared!");
            System.out.printf("Change: %.2f%n", change);
            outstandingFine = 0;
        }
    }
}

