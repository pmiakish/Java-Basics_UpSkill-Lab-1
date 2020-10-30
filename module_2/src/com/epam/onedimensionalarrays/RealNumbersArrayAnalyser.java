package com.epam.onedimensionalarrays;

/**
 * Task #3:
 * The class for counting numbers of negative, positive, and zero elements,
 * which an array of real numbers contains.
 */

public class RealNumbersArrayAnalyser {

    private static final int NUMBER_OF_CHARACTERISTICS = 3;

    public static int[] characterizeArray(double[] generatedNumbers) {
        int[] arrayCharacteristics = new int[NUMBER_OF_CHARACTERISTICS];
        for (double currentNumber : generatedNumbers) {
            if (currentNumber > 0) {
                arrayCharacteristics[0]++; // positive numbers
            } else if (currentNumber < 0) {
                arrayCharacteristics[1]++; // negative numbers
            } else {
                arrayCharacteristics[2]++; // zeros
            }
        }
        return arrayCharacteristics;
    }
}
