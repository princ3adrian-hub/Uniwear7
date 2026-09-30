package com.example.quarter2.PracticalExam.Rutor;

import java.util.Scanner;

public class GymMenu {

    public void start(Scanner scanner) {

        boolean lifting = true;

        // ==========================================
        // GYM WELCOME SCREEN
        // ==========================================

        System.out.println();
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║              🏋️  RUTOR FITNESS              ║");
        System.out.println("║            GYM ACCESS TERMINAL               ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║                                              ║");
        System.out.println("║      Welcome to Rutor Fitness Center!        ║");
        System.out.println("║                                              ║");
        System.out.println("║      Would you like to enter the gym?        ║");
        System.out.println("║                                              ║");
        System.out.println("║      [1] YES - Enter Gym                     ║");
        System.out.println("║      [2] NO  - Stay Outside                 ║");
        System.out.println("║                                              ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("➜ Select option: ");

        while (lifting && scanner.hasNextLine()) {

            String input = scanner.nextLine().trim();

            switch (input) {

                // ==========================================
                // ENTER GYM
                // ==========================================

                case "1":

                    System.out.println();
                    System.out.println("╔══════════════════════════════════════════════╗");
                    System.out.println("║              🔓 ACCESS GRANTED               ║");
                    System.out.println("╠══════════════════════════════════════════════╣");
                    System.out.println("║                                              ║");
                    System.out.println("║   Welcome inside, athlete! 💪                ║");
                    System.out.println("║   Your workout session is ready.             ║");
                    System.out.println("║                                              ║");
                    System.out.println("╚══════════════════════════════════════════════╝");

                    System.out.println();

                    // ==========================================
                    // TRAINER MENU
                    // ==========================================

                    System.out.println("╔══════════════════════════════════════════════╗");
                    System.out.println("║             🏆 PREMIUM SERVICES              ║");
                    System.out.println("╠══════════════════════════════════════════════╣");
                    System.out.println("║                                              ║");
                    System.out.println("║   Would you like to hire a trainer?          ║");
                    System.out.println("║                                              ║");
                    System.out.println("║   ⚠ VIP MEMBERSHIP REQUIRED                  ║");
                    System.out.println("║                                              ║");
                    System.out.println("║   [1] YES - Hire Trainer                     ║");
                    System.out.println("║   [2] NO  - Continue Workout                ║");
                    System.out.println("║                                              ║");
                    System.out.println("╚══════════════════════════════════════════════╝");
                    System.out.print("➜ Select option: ");

                    if (scanner.hasNextLine()) {

                        String tierInput = scanner.nextLine().trim();

                        // ==========================================
                        // HIRE TRAINER
                        // ==========================================

                        if (tierInput.equals("1")) {

                            System.out.println();
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║              👤 USER PROFILE                 ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");
                            System.out.println("║  Username       : #########                  ║");
                            System.out.println("║  Membership     : REGULAR                    ║");
                            System.out.println("║  Trainer Status : 🔒 VIP ONLY                ║");
                            System.out.println("║                                              ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║  ⚠ TRAINER ACCESS DENIED                    ║");
                            System.out.println("║                                              ║");
                            System.out.println("║  A VIP membership is required to hire        ║");
                            System.out.println("║  a personal trainer.                         ║");
                            System.out.println("║                                              ║");
                            System.out.println("╚══════════════════════════════════════════════╝");

                            System.out.println();
                            System.out.println("🔒 Trainer assignment: UNAVAILABLE");
                            System.out.println("💡 Upgrade to VIP to unlock this feature!");

                            System.out.println();
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║             SESSION OPTIONS                  ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");
                            System.out.println("║                 [3] EXIT                     ║");
                            System.out.println("║                                              ║");
                            System.out.println("╚══════════════════════════════════════════════╝");
                            System.out.print("➜ Select option: ");

                        }

                        // ==========================================
                        // NO TRAINER
                        // ==========================================

                        else if (tierInput.equals("2")) {

                            System.out.println();
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║              👤 USER PROFILE                 ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");
                            System.out.println("║  Username       : #########                  ║");
                            System.out.println("║  Membership     : REGULAR                    ║");
                            System.out.println("║  Trainer Status : NONE                       ║");
                            System.out.println("║                                              ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║              💎 VIP FEATURE                  ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");
                            System.out.println("║  Personal trainers are available exclusively ║");
                            System.out.println("║  to VIP members.                             ║");
                            System.out.println("║                                              ║");
                            System.out.println("║  🔔 NEED TO UPGRADE MEMBERSHIP!              ║");
                            System.out.println("║                                              ║");
                            System.out.println("╚══════════════════════════════════════════════╝");

                            System.out.println();
                            System.out.println("💪 You may continue your workout with");
                            System.out.println("   the regular gym facilities.");

                            System.out.println();
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║             SESSION OPTIONS                  ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");
                            System.out.println("║                 [3] EXIT                     ║");
                            System.out.println("║                                              ║");
                            System.out.println("╚══════════════════════════════════════════════╝");
                            System.out.print("➜ Select option: ");
                        }
                    }

                    break;

            }
        }
    }
}