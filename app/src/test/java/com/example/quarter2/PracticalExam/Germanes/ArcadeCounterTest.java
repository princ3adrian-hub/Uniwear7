package com.example.quarter2.PracticalExam.Germanes;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ArcadeCounterTest {

    @Test
    public void testArcadeFlow() {

        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING ARCADE TEST DATA ---");

        // Step 1: Buy tokens option
        automatedInput.append("1\n");

        // Step 2: Test low ticket count for prize
        automatedInput.append("2\n");
        automatedInput.append("200\n");

        // Step 3: Test high ticket count for prize
        automatedInput.append("2\n");
        automatedInput.append("600\n");

        // Step 4: Exit system
        automatedInput.append("3\n");

        System.out.println("--- TEST DATA GENERATION COMPLETE ---");

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        automatedInput.toString().getBytes()
                );

        Scanner scanner = new Scanner(inputStream);


    }
}
