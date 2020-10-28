package com.epam.onedimensionalarrays;

/**
 * Task #5:
 * The class for printing only those elements of integer array
 * which values conform to the condition ai>i.
 */

public class PrinterOfNumbersGreaterThanTheirIndexes {
    public static void printValues(int[] generatedNumbers) {
        System.out.println("\nThe elements of array with values greater than their indexes: ");
        for (int currentIndex = 0; currentIndex < generatedNumbers.length; currentIndex++) {
            if (generatedNumbers[currentIndex] > currentIndex) {
                System.out.print(generatedNumbers[currentIndex] + " ");
            }
        }
    }
}
