package com.epam.payment.service;

import com.epam.payment.entity.Payment;
import com.epam.payment.exceptions.PurchaseLogicalException;
import com.epam.payment.util.init.RandomNumberGenerator;

import java.math.BigDecimal;

public class PaymentAggregator {

    private static final String[][] ITEMS = {
            {"Sausages, kg", "Bread", "Yogurt", "Apples, kg", "Milk, l", "Juice, l", "Meat, kg", "Eggs, dozens"},
            {"15.3", "1.2", "2.5", "1.45", "2.25", "3.1", "12.1", "3.15"},
    };
    private static final int MIN_NUMBER_OF_PIECES = 1;
    private static final int MAX_NUMBER_OF_PIECES = 5;

    public static void main(String[] args) {
        try {
            Payment payment = new Payment();
            for (int i = 0; i < ITEMS[0].length; i++) {
                payment.addPurchase(ITEMS[0][i], BigDecimal.valueOf(Double.parseDouble(ITEMS[1][i])),
                        RandomNumberGenerator.generate(MIN_NUMBER_OF_PIECES, MAX_NUMBER_OF_PIECES));
            }

            System.out.println(payment);
            System.out.println("The total amount: " + payment.getTotalAmount());

        } catch (PurchaseLogicalException e) {
            e.printStackTrace();
        }
    }
}
