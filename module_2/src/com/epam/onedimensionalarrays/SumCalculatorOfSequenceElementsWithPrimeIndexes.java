package com.epam.onedimensionalarrays;

/**
 * Task #6:
 * The class for calculating the sum of sequence elements
 * which indexes are prime numbers.
 * The sequence includes real numbers.
 */

public class SumCalculatorOfSequenceElementsWithPrimeIndexes {

    private static final int FIRST_PRIME_INDEX = 2;
    private static final int MIN_DIVISOR_FOR_PRIME_INDEX = 2;

    public static double countSum(double[] generatedNumbers) {
        double sum = 0.0;
        for (int currentIndex = FIRST_PRIME_INDEX; currentIndex < generatedNumbers.length; currentIndex++) {
            boolean isCompositeIndex = false;
            for (int divisor = MIN_DIVISOR_FOR_PRIME_INDEX; divisor <= Math.round(Math.sqrt(currentIndex)); divisor++) {
                if (currentIndex % divisor == 0) {
                    isCompositeIndex = true;
                    break;
                }
            }
            if (!isCompositeIndex) {
                sum += generatedNumbers[currentIndex];
            }
        }
        return sum;
    }
}
