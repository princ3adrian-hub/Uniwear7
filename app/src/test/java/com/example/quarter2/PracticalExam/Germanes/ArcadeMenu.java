package com.example.quarter2.PracticalExam.Germanes;

import java.util.Scanner;

public class ArcadeMenu {

    public void start(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=== ARCADE MENU ===");
            System.out.println("1. Buy Tokens");
            System.out.println("2. Claim Prize");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    buyTokens(scanner);
                    break;

                case 2:
                    claimPrize(scanner);
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void buyTokens(Scanner scanner) {

        System.out.print("Enter number of tokens: ");

        int tokens = scanner.nextInt();

        System.out.println("You bought " + tokens + " tokens.");
    }

    private void claimPrize(Scanner scanner) {

        System.out.print("Enter your tickets: ");

        int tickets = scanner.nextInt();

        if (tickets >= 500) {
            System.out.println("Teddy Bear Won!");
        } else {
            System.out.println("Keep Playing!");
        }
    }
}