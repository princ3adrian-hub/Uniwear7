package com.example.quarter2.PracticalExam.Paguirigan;

import java.util.Scanner;

public class LibraryKioskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new LibraryMenu().start(scanner);
        scanner.close();
    }
}
