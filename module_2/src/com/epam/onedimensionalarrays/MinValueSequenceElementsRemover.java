package com.epam.onedimensionalarrays;

/**
 * Task #8:
 * The class for removing min values from
 * the sequence of integer numbers [а1 ,а2 ,..., аn].
 */

public class MinValueSequenceElementsRemover {

    private static int minValue = 0;
    private static int amountOfMinValues = 0;

    public static int[] removeElements(int[] generatedNumbers) {
        searchMinElements(generatedNumbers);
        int[] arrayWithRemovedMinValues;
        if (amountOfMinValues < generatedNumbers.length) {
            arrayWithRemovedMinValues = new int[generatedNumbers.length - amountOfMinValues];
            int arrayIndex = 0;
            for (int oldArrayCurrentValue : generatedNumbers) {
                if (oldArrayCurrentValue != minValue) {
                    arrayWithRemovedMinValues[arrayIndex] = oldArrayCurrentValue;
                    arrayIndex++;
                }
            }
        } else { // all the elements of the array equals to each other
            arrayWithRemovedMinValues = null;
            System.out.println("Min value not found!");
        }
        return arrayWithRemovedMinValues;
    }

    private static void searchMinElements(int[] generatedNumbers) {
        minValue = generatedNumbers[0];
        amountOfMinValues = 1;
        for (int currentIndex = 1; currentIndex < generatedNumbers.length; currentIndex++) {
            if (generatedNumbers[currentIndex] < minValue) {
                minValue = generatedNumbers[currentIndex];
                amountOfMinValues = 1;
            } else if (generatedNumbers[currentIndex] == minValue) {
                amountOfMinValues++;
            }
        }
    }

}
