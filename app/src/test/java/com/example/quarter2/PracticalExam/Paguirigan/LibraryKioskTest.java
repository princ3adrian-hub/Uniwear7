package com.example.quarter2.PracticalExam.Paguirigan;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
public class LibraryKioskTest {
    @Test
    public void testLibraryFlow() {
        StringBuilder automatedInput = new StringBuilder();
        System.out.println("--- GENERATING LIBRARY TEST DATA ---");
// Step 1: Borrow book option
        automatedInput.append("1\n"); // Choose Borrow Book
// Step 2: Test insufficient fine payment (< 15)
        automatedInput.append("2\n"); // Choose Pay Fines
        automatedInput.append("10\n"); // Enter payment 10 (Expected: Insufficient)
// Step 3: Test sufficient fine payment (>= 15)
        automatedInput.append("2\n"); // Choose Pay Fines
        automatedInput.append("50\n"); // Enter payment 50 (Expected: Change calculation)
// Step 4: Exit system
        automatedInput.append("3\n"); // Choose Exit
        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.toString().getBytes());
        Scanner scanner = new Scanner(inputStream);
        LibraryMenu librarySystem = new LibraryMenu();
        librarySystem.start(scanner);
    }
}