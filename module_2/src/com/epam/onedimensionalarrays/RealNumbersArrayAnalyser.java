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
        arrayCharacteristics[0] = 0; // positive numbers
        arrayCharacteristics[1] = 0; // negative numbers
        arrayCharacteristics[2] = 0; // zeros
        for (double currentNumber : generatedNumbers) {
            if (currentNumber > 0) {
                arrayCharacteristics[0]++;
            } else if (currentNumber < 0) {
                arrayCharacteristics[1]++;
            } else {
                arrayCharacteristics[2]++;
            }
        }
        return arrayCharacteristics;
    }
}
