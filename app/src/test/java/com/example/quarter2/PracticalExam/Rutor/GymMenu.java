package com.example.quarter2.PracticalExam.Rutor;

import java.util.Scanner;

public class GymMenu {

    // This method starts the gym menu.
    // The Scanner is used to read the user's input.
    public void start(Scanner scanner) {

        // This boolean controls if the gym menu should keep running.
        // It becomes false when the user chooses Exit.
        boolean lifting = true;

        // ==========================================
        // GYM WELCOME SCREEN
        // ==========================================

        // Prints an empty line to make the output cleaner.
        System.out.println();

        // Prints the title of the gym program.
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║              🏋️  RUTOR FITNESS              ║");
        System.out.println("║            GYM ACCESS TERMINAL               ║");
        System.out.println("╠══════════════════════════════════════════════╣");

        // Displays a welcome message.
        System.out.println("║                                              ║");
        System.out.println("║      Welcome to Rutor Fitness Center!        ║");
        System.out.println("║                                              ║");

        // Asks the user if they want to enter the gym.
        System.out.println("║      Would you like to enter the gym?        ║");
        System.out.println("║                                              ║");

        // Displays the available choices.
        System.out.println("║      [1] YES - Enter Gym                     ║");
        System.out.println("║      [2] NO  - Stay Outside                 ║");
        System.out.println("║                                              ║");

        // Closes the welcome screen.
        System.out.println("╚══════════════════════════════════════════════╝");

        // Tells the user to enter their choice.
        System.out.print("➜ Select option: ");

        // ==========================================
        // MAIN GYM LOOP
        // ==========================================

        // The loop continues while lifting is true
        // and there is still input available.
        while (lifting && scanner.hasNextLine()) {

            // Gets the user's input.
            // trim() removes extra spaces before and after the input.
            String input = scanner.nextLine().trim();

            // Checks which option the user selected.
            switch (input) {

                // ==========================================
                // OPTION 1 - ENTER GYM
                // ==========================================

                case "1":

                    // Displays a message when the user enters the gym.
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

                    // Displays the trainer menu after entering the gym.
                    System.out.println("╔══════════════════════════════════════════════╗");
                    System.out.println("║             🏆 PREMIUM SERVICES              ║");
                    System.out.println("╠══════════════════════════════════════════════╣");
                    System.out.println("║                                              ║");

                    // Asks if the user wants to hire a trainer.
                    System.out.println("║   Would you like to hire a trainer?          ║");
                    System.out.println("║                                              ║");

                    // Shows that only VIP members can hire a trainer.
                    System.out.println("║   ⚠ VIP MEMBERSHIP REQUIRED                  ║");
                    System.out.println("║                                              ║");

                    // Displays the trainer choices.
                    System.out.println("║   [1] YES - Hire Trainer                     ║");
                    System.out.println("║   [2] NO  - Continue Workout                ║");
                    System.out.println("║                                              ║");
                    System.out.println("╚══════════════════════════════════════════════╝");

                    // Asks the user to select a trainer option.
                    System.out.print("➜ Select option: ");

                    // Checks if another line of input is available.
                    if (scanner.hasNextLine()) {

                        // Gets the user's trainer choice.
                        String tierInput = scanner.nextLine().trim();

                        // ==========================================
                        // TRAINER OPTION 1 - HIRE TRAINER
                        // ==========================================

                        // Checks if the user selected Yes.
                        if (tierInput.equals("1")) {

                            // Displays the user's profile.
                            System.out.println();
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║              👤 USER PROFILE                 ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");

                            // Displays basic user information.
                            System.out.println("║  Username       : #########                  ║");
                            System.out.println("║  Membership     : REGULAR                    ║");
                            System.out.println("║  Trainer Status : 🔒 VIP ONLY                ║");
                            System.out.println("║                                              ║");

                            System.out.println("╠══════════════════════════════════════════════╣");

                            // Tells the user that the trainer cannot be hired.
                            System.out.println("║  ⚠ TRAINER ACCESS DENIED                    ║");
                            System.out.println("║                                              ║");
                            System.out.println("║  A VIP membership is required to hire        ║");
                            System.out.println("║  a personal trainer.                         ║");
                            System.out.println("║                                              ║");

                            System.out.println("╚══════════════════════════════════════════════╝");

                            // Displays additional information.
                            System.out.println();
                            System.out.println("🔒 Trainer assignment: UNAVAILABLE");
                            System.out.println("💡 Upgrade to VIP to unlock this feature!");

                            System.out.println();

                            // Displays the option to exit.
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║             SESSION OPTIONS                  ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");
                            System.out.println("║                 [3] EXIT                     ║");
                            System.out.println("║                                              ║");
                            System.out.println("╚══════════════════════════════════════════════╝");

                            // Asks for the next menu choice.
                            System.out.print("➜ Select option: ");
                        }

                        // ==========================================
                        // TRAINER OPTION 2 - NO TRAINER
                        // ==========================================

                        // Checks if the user selected No.
                        else if (tierInput.equals("2")) {

                            // Displays the user's profile.
                            System.out.println();
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║              👤 USER PROFILE                 ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");

                            // Displays the user's account information.
                            System.out.println("║  Username       : #########                  ║");
                            System.out.println("║  Membership     : REGULAR                    ║");
                            System.out.println("║  Trainer Status : NONE                       ║");
                            System.out.println("║                                              ║");

                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║              💎 VIP FEATURE                  ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");

                            // Explains the VIP trainer feature.
                            System.out.println("║  Personal trainers are available exclusively ║");
                            System.out.println("║  to VIP members.                             ║");
                            System.out.println("║                                              ║");
                            System.out.println("║  🔔 NEED TO UPGRADE MEMBERSHIP!              ║");
                            System.out.println("║                                              ║");

                            System.out.println("╚══════════════════════════════════════════════╝");

                            // Tells the user they can still use the gym.
                            System.out.println();
                            System.out.println("💪 You may continue your workout with");
                            System.out.println("   the regular gym facilities.");

                            System.out.println();

                            // Displays the exit option.
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║             SESSION OPTIONS                  ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║                                              ║");
                            System.out.println("║                 [3] EXIT                     ║");
                            System.out.println("║                                              ║");
                            System.out.println("╚══════════════════════════════════════════════╝");

                            // Asks for the next menu choice.
                            System.out.print("➜ Select option: ");
                        }
                    }

                    // Ends case 1.
                    break;

                // ==========================================
                // OPTION 3 - EXIT
                // ==========================================

                case "3":

                    // Displays the goodbye message.
                    System.out.println();
                    System.out.println("╔══════════════════════════════════════════════╗");
                    System.out.println("║             🔒 SESSION CLOSED                ║");
                    System.out.println("╠══════════════════════════════════════════════╣");
                    System.out.println("║                                              ║");
                    System.out.println("║       Thank you for visiting Rutor           ║");
                    System.out.println("║              Fitness Center!                 ║");
                    System.out.println("║                                              ║");
                    System.out.println("║       💪 KEEP GRINDING, ATHLETE! 💪          ║");
                    System.out.println("║                                              ║");
                    System.out.println("╚══════════════════════════════════════════════╝");

                    // Changes lifting to false.
                    // This stops the while loop.
                    lifting = false;

                    // Ends case 3.
                    break;

                // ==========================================
                // INVALID INPUT
                // ==========================================

                default:

                    // This runs when the user enters
                    // something other than the available options.
                    System.out.println();
                    System.out.println("╔══════════════════════════════════════════════╗");
                    System.out.println("║              ⚠ INVALID OPTION                ║");
                    System.out.println("╠══════════════════════════════════════════════╣");
                    System.out.println("║                                              ║");
                    System.out.println("║   Please enter a valid menu option.          ║");
                    System.out.println("║                                              ║");
                    System.out.println("╚══════════════════════════════════════════════╝");

                    // Asks the user to enter another option.
                    System.out.print("➜ Try again: ");

                    // Ends the default section.
                    break;
            }
        }
    }
}