package com.example.quarter2.PracticalExam.Magcaling;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class FastFoodTest {

    @Test
    public void testFastFoodFlow() {
        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING FAST FOOD TEST DATA ---");

        // Step 1: Order Burger as Combo
        automatedInput.append("1\n"); // Choose Order Burger
        automatedInput.append("1\n"); // Choose Combo

        // Step 2: Order Burger as Solo
        automatedInput.append("1\n"); // Choose Order Burger
        automatedInput.append("2\n"); // Choose Solo

        // Step 3: Order Fries
        automatedInput.append("2\n"); // Choose Order Fries

        // Step 4: Exit system
        automatedInput.append("3\n"); // Choose Exit

        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");

        // Convert automated input to InputStream
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        automatedInput.toString().getBytes()
                );

        // Create Scanner
        Scanner scanner = new Scanner(inputStream);

    }

}








