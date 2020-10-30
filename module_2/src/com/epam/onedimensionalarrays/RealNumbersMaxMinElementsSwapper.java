package com.epam.onedimensionalarrays;

/**
 * Task #4:
 * The class for swapping the min and max elements in the array of real numbers
 */

public class RealNumbersMaxMinElementsSwapper {

    public static double[] swapElements(double[] generatedNumbers) {
        final int maxElementIndex = searchForMaxMinElements(generatedNumbers, true);
        final int minElementIndex = searchForMaxMinElements(generatedNumbers, false);
        if (maxElementIndex != -1 && minElementIndex != -1) {
            rewriteValues(generatedNumbers, maxElementIndex, minElementIndex);
        } else {
            System.out.println("\nMultiple max or min values!");
            generatedNumbers = null;
        }
        return generatedNumbers;
    }

    private static int searchForMaxMinElements (double[] generatedNumbers, boolean searchingMaxNumber) {
        int foundedIndex = 0;
        boolean areMultipleItems = false;
        for (int currentIndex = 1; currentIndex < generatedNumbers.length; currentIndex++) {
            if (searchingMaxNumber) {
                // searching for max number
                if (generatedNumbers[currentIndex] > generatedNumbers[foundedIndex]) {
                    foundedIndex = currentIndex;
                    areMultipleItems = false;
                } else if (generatedNumbers[currentIndex] == generatedNumbers[foundedIndex]) {
                    areMultipleItems = true;
                }
            } else {
                // searching for min number
                if (generatedNumbers[currentIndex] < generatedNumbers[foundedIndex]) {
                    foundedIndex = currentIndex;
                    areMultipleItems = false;
                } else if (generatedNumbers[currentIndex] == generatedNumbers[foundedIndex]) {
                    areMultipleItems = true;
                }
            }
        }
        return areMultipleItems ? -1 : foundedIndex;
    }

    private static void rewriteValues (double[] generatedNumbers, final int maxElementIndex,
                                       final int minElementIndex) {
        double temporary = generatedNumbers[maxElementIndex];
        generatedNumbers[maxElementIndex] = generatedNumbers[minElementIndex];
        generatedNumbers[minElementIndex] = temporary;
    }
}
