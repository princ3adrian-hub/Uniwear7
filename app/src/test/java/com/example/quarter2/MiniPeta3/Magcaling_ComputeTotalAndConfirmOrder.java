package com.example.quarter2.MiniPeta3;

public class Magcaling_ComputeTotalAndConfirmOrder {
//minipeta
    // Stores the calculated total cost of the selected items.
    double totalPrice;

    // Stores the preferred payment method details.
    String paymentMethod;

    // Tracks whether the payment process was successful.
    boolean paymentStatus;

    // Constructor
    public Magcaling_ComputeTotalAndConfirmOrder(double totalPrice,
                                                 String paymentMethod,
                                                 boolean paymentStatus) {

        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Displays the order information.
    public void confirmOrder() {
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Status: " + paymentStatus);
    }

    // Main method
    public static void main(String[] args) {

        Magcaling_ComputeTotalAndConfirmOrder order =
                new Magcaling_ComputeTotalAndConfirmOrder(
                        500.00,
                        "GCash",
                        true
                );

        order.confirmOrder();
    }
}
