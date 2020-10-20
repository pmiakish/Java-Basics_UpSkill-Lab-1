package com.epam.cycles;

import java.util.Scanner;

public class CyclesTaskG {

    private static final int AMOUNT_OF_NUMBERS = 2;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] numbers = new int[AMOUNT_OF_NUMBERS];
        int [] numberLength = new int[AMOUNT_OF_NUMBERS];
            for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
                System.out.print ("Enter the number " + (i + 1) + ": ");
                numbers[i] = Math.abs(console.nextInt());
                numberLength[i] = String.valueOf(numbers[i]).length();
            }
        for (int n = 0; n < AMOUNT_OF_NUMBERS; n++) {
            System.out.print ("\nDigits of the number '" + numbers[n] + "': ");
            for (int rank = numberLength[n] - 1; rank >= 1; rank--) {
                System.out.print ((numbers[n] / ((int) Math.pow(10, rank))) + ", ");
                numbers[n] %= (int) Math.pow(10, rank);
                    if (rank == 1) {
                        System.out.print (numbers[n] + ".");
                    }
            }
        }

    }


}
