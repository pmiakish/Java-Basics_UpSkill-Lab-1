package com.epam.payment.start;

import com.epam.payment.entity.Payment;
import com.epam.payment.util.init.PaymentInitializer;

public class PaymentController {

    public static void main(String[] args) {
        try {
            Payment payment = new Payment();
            PaymentInitializer.collectPurchases(payment);
            System.out.println(payment);
            System.out.println("The total amount: " + payment.getTotalAmount());
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
