package com.example.quarter2.MiniPeta3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Germanes_LoginAndVerification {

    private static final Map<Integer, String> ACCOUNTS = new HashMap<>();
    static {
        ACCOUNTS.put(202301, "password123");
        ACCOUNTS.put(202302, "mcs2026");
        ACCOUNTS.put(202303, "uniwear01");
    }

    private int studentId;
    private String password;
    private boolean isVerified;

    public Germanes_LoginAndVerification(int studentId, String password) {
        this.studentId = studentId;
        this.password = password;
        this.isVerified = verify();
    }

    private boolean verify() {
        if (!ACCOUNTS.containsKey(studentId)) {
            return false;
        }
        return ACCOUNTS.get(studentId).equals(password);
    }

    public boolean isVerified() {
        return isVerified;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        Germanes_LoginAndVerification login = new Germanes_LoginAndVerification(studentId, password);

        if (login.isVerified()) {
            System.out.println("Login successful! You are verified.");
        } else if (!ACCOUNTS.containsKey(studentId)) {
            System.out.println("Student ID not found.");
        } else {
            System.out.println("Incorrect password. Please try again.");
        }

        scanner.close();
    }
}