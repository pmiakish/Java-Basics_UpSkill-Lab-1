package com.epam.cycles;
import java.math.BigInteger;

public class CyclesTaskD {

    private static final int AMOUNT_OF_NUMBERS = 200;

    public static void main(String[] args) {
        BigInteger product = new BigInteger("1");
        BigInteger squareNumber;
        for (int i = 1; i <= AMOUNT_OF_NUMBERS; i++) {
            squareNumber = BigInteger.valueOf(i * i);
            product = product.multiply(squareNumber);
        }
        System.out.println("The product of the first " + AMOUNT_OF_NUMBERS + " square numbers is " + product);
    }
}
