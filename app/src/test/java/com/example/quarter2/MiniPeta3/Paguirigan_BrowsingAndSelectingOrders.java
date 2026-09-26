package com.example.quarter2.MiniPeta3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

@SuppressWarnings("JUnitTestClassNamingConvention")
public class Paguirigan_BrowsingAndSelectingOrders {

    // variable declarations, matching specifications
    private String uniformType;
    private String uniformSize;
    private int quantity;
    private boolean isAvailable;

    @Before
    public void setUp() {
        // resets the variables before each test
        uniformType = "";
        uniformSize = "";
        quantity = 0;
        isAvailable = false;
    }

    // simulate order validation and availability check
    public boolean processOrder(String type, String size, int qty) {
        this.uniformType = type;
        this.uniformSize = size;
        this.quantity = qty;

        // stock availability
        this.isAvailable = type != null && !type.trim().isEmpty() &&
                size != null && !size.trim().isEmpty() &&
                qty > 0;

        return this.isAvailable;
    }

    // interactive inputs
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Paguirigan_BrowsingAndSelectingOrders system = new Paguirigan_BrowsingAndSelectingOrders();

        System.out.println("=== ORDERS ===");

        System.out.print("Enter Uniform Type (PE OR Uniform): ");
        String type = scanner.nextLine();

        System.out.print("Enter Uniform Size (Small, Medium, Large, XL): ");
        String size = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int qty;
        if (scanner.hasNextInt()) {
            qty = scanner.nextInt();
        } else {
            System.out.println("Invalid input for quantity! Defaulting to 0.");
            qty = 0;
        }

        system.processOrder(type, size, qty);

        System.out.println("\n--- ORDER SUMMARY ---");
        System.out.println("Uniform Type : " + system.getUniformType());
        System.out.println("Uniform Size : " + system.getUniformSize());
        System.out.println("Quantity     : " + system.getQuantity());
        System.out.println("Available? : " + (system.isAvailable() ? "Yes (True)" : "No (False)"));

        scanner.close();
    }

    @Test
    public void testValidOrderSelection() {
        // Test selecting a valid uniform order
        boolean result = processOrder("PE Uniform", "Medium", 2);

        Assert.assertEquals("PE Uniform", uniformType);
        Assert.assertEquals("Medium", uniformSize);
        Assert.assertEquals(2, quantity);
        Assert.assertTrue("Order should be marked as available for valid selection", result);
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void testInvalidOrder_ZeroQuantity() {
        // Test selecting an order with 0 quantity
        boolean result = processOrder("PE Uniform", "Large", 0);

        Assert.assertFalse("Order should not be available if quantity is zero", result);
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void testInvalidOrder_EmptyType() {
        // Test selecting an order with empty uniform type
        boolean result = processOrder("", "Small", 1);

        Assert.assertFalse("Order should not be available if uniform type is missing", result);
        Assert.assertFalse(isAvailable);
    }

    // get and set matching specification data types
    public String getUniformType() {
        return uniformType;
    }

    @SuppressWarnings("unused")
    public void setUniformType(String uniformType) {
        this.uniformType = uniformType;
    }

    public String getUniformSize() {
        return uniformSize;
    }

    @SuppressWarnings("unused")
    public void setUniformSize(String uniformSize) {
        this.uniformSize = uniformSize;
    }

    public int getQuantity() {
        return quantity;
    }

    @SuppressWarnings("unused")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @SuppressWarnings("unused")
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}