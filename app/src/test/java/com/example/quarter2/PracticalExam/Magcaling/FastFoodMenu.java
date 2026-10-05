package com.example.quarter2.PracticalExam.Magcaling;

import java.util.Scanner;
//foodmenu
public class FastFoodMenu {

    public static void subMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- SUB MENU ---");
        System.out.println("1. Burger");
        System.out.println("2. Fries");
        System.out.println("3. Drinks");
        System.out.println("4. Back");

        System.out.print("Choose: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Burger selected!");
        } else if (choice == 2) {
            System.out.println("Fries selected!");
        } else if (choice == 3) {
            System.out.println("Drinks selected!");
        } else {
            System.out.println("Back to main menu.");
        }
    }

    public static void main(String[] args) {
        subMenu();
    }
}
