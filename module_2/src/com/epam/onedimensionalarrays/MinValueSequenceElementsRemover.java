package com.epam.onedimensionalarrays;

/**
 * Task #8:
 * The class for removing min values from
 * the sequence of integer numbers [а1 ,а2 ,..., аn].
 */

public class MinValueSequenceElementsRemover {

    private static final int AMOUNT_OF_CHARACTERISTICS = 2;

    public static int[] removeElements(int[] generatedNumbers) {
        int[] minValuesAndTheirAmount = searchMinElements(generatedNumbers);
        int[] arrayWithRemovedMinValues;
        if (minValuesAndTheirAmount[1] < generatedNumbers.length) {
            arrayWithRemovedMinValues = new int[generatedNumbers.length - minValuesAndTheirAmount[1]];
            int arrayIndex = 0;
            for (int oldArrayCurrentValue : generatedNumbers) {
                if (oldArrayCurrentValue != minValuesAndTheirAmount[0]) {
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

    private static int[] searchMinElements(int[] generatedNumbers) {
        int[] minValuesAndTheirAmount = new int[AMOUNT_OF_CHARACTERISTICS];
        minValuesAndTheirAmount[0] = generatedNumbers[0];
        minValuesAndTheirAmount[1] = 1;
        for (int currentIndex = 1; currentIndex < generatedNumbers.length; currentIndex++) {
            if (generatedNumbers[currentIndex] < minValuesAndTheirAmount[0]) {
                minValuesAndTheirAmount[0] = generatedNumbers[currentIndex];
                minValuesAndTheirAmount[1] = 1;
            } else if (minValuesAndTheirAmount[0] == generatedNumbers[currentIndex]) {
                minValuesAndTheirAmount[1]++;
            }
        }
        return minValuesAndTheirAmount;
    }

}
