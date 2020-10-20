package com.epam.cycles;
import java.math.BigInteger;

public class CyclesTaskD {

    private static final int AMOUNT_OF_NUMBERS = 200;

    public static void main(String[] args) {
        BigInteger composition = new BigInteger("1");
        for (int i = 2; i <= AMOUNT_OF_NUMBERS; i++) {
            composition = composition.multiply(BigInteger.valueOf(i * i));
        }
        System.out.println("The composition of the first " + AMOUNT_OF_NUMBERS + " square numbers is " + composition);
    }
}
