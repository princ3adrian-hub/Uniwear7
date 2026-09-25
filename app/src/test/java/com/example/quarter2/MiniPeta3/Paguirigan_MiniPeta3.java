package com.example.quarter2.MiniPeta3;

public class Paguirigan_MiniPeta3 {

        // Variables from the table
        private String uniformType;   // -String: Stores the selected type of uniform
        private String uniformSize;   // -String: Stores the selected size for the selected uniform
        private int quantity;         // -Int: Stores the amount of uniforms that has been selected
        private boolean isAvailable;  // -Boolean (t/f): Tracks the stock status for selected uniform

        public Paguirigan_MiniPeta3() {
            this.uniformType = "";
            this.uniformSize = "";
            this.quantity = 0;
            this.isAvailable = false;
        }

        // Capture the student's uniform selection
        public void selectUniform(String uniformType, String uniformSize, int quantity) {
            this.uniformType = uniformType;
            this.uniformSize = uniformSize;
            this.quantity = quantity;
        }

        // Checks stock status for the selected uniform and updates isAvailable
        public boolean checkAvailability(int stockCount) {
            if (stockCount >= this.quantity && this.quantity > 0) {
                this.isAvailable = true;
            } else {
                this.isAvailable = false;
            }
            return this.isAvailable;
        }

        public void displaySelection() {
            System.out.println("Uniform Type: " + this.uniformType);
            System.out.println("Uniform Size: " + this.uniformSize);
            System.out.println("Quantity: " + this.quantity);
            if (this.isAvailable) {
                System.out.println("Status: Available - Order can proceed.");
            } else {
                System.out.println("Status: Unavailable - Insufficient stock or invalid quantity.");
            }
        }

        // Getters and setters
        public String getUniformType() {
            return uniformType;
        }

        public String getUniformSize() {
            return uniformSize;
        }

        public int getQuantity() {
            return quantity;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public static void main(String[] args) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);

            // Simulated stock record (e.g., from a database)
            final int STOCK_COUNT = 15;

            Paguirigan_MiniPeta3  order = new Paguirigan_MiniPeta3 ();

            System.out.print("Enter Uniform Type (e.g., PE, School): ");
            String type = scanner.nextLine();

            System.out.print("Enter Uniform Size (e.g., S, M, L, XL): ");
            String size = scanner.nextLine();

            System.out.print("Enter Quantity: ");
            int qty = scanner.nextInt();

            order.selectUniform(type, size, qty);
            order.checkAvailability(STOCK_COUNT);
            order.displaySelection();

            scanner.close();
        }
    }


