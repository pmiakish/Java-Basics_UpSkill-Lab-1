package com.epam.payment.util.init;

import com.epam.payment.entity.Payment;
import java.math.BigDecimal;

public class PaymentInitializer {

    private static final String[][] ITEMS = {
            {"Sausages, kg", "Bread", "Yogurt", "Apples, kg", "Milk, l", "Juice, l", "Meat, kg", "Eggs, dozens"},
            {"15.3", "1.2", "2.5", "1.45", "2.25", "3.1", "12.1", "3.15"},
    };
    private static final int MIN_NUMBER_OF_PIECES = 1;
    private static final int MAX_NUMBER_OF_PIECES = 5;

    public static void collectPurchases(Payment payment) throws IllegalArgumentException, NullPointerException {
        for (int i = 0; i < ITEMS[0].length; i++) {
            payment.addPurchase(ITEMS[0][i], BigDecimal.valueOf(Double.parseDouble(ITEMS[1][i])),
                    RandomNumberGenerator.generate(MIN_NUMBER_OF_PIECES, MAX_NUMBER_OF_PIECES));
        }
    }

}
