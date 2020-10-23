package com.epam.module1.cycles;

public class CyclesTaskC {

    private static final int AMOUNT_OF_NUMBERS = 100;

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= AMOUNT_OF_NUMBERS; i++) {
            sum += i * i;
        }
        System.out.println("The sum of the first " + AMOUNT_OF_NUMBERS + " square numbers is " + sum);
    }
}