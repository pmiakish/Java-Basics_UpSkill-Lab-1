package com.epam.onedimensionalarrays;

/**
 * Task #1:
 * The class for calculating the sum of the elements that are divisible by K.
 * The array contains natural numbers.
 */

public class SumCalculatorOfNumbersDivisibleByK {
    public static int countSum(int[] generatedNumbers, int divisorK) {
        int sum = -1;
        if (divisorK != 0) {
            sum = 0;
            for (int currentNumber : generatedNumbers) {
                if ((currentNumber % divisorK) == 0) {
                    sum += currentNumber;
                }
            }
        } else {
            System.out.println("\nIncorrect divisor value!");
        }
    return sum;
    }
}
