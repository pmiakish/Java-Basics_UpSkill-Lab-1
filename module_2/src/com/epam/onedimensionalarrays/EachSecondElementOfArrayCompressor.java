package com.epam.onedimensionalarrays;

/**
 * Task #10:
 * The class for optimizing integer array elements
 * (compression of each second element, filling emptied elements with zeros).
 */

public class EachSecondElementOfArrayCompressor {

    public static int[] compressArray(int[] generatedNumbers) {
        rewriteElementsWithEvenIndexes(generatedNumbers);
        for (int i = (int) Math.round(generatedNumbers.length / 2.0); i < generatedNumbers.length; i++) {
            generatedNumbers[i] = 0;
        }
        return generatedNumbers;
    }

    private static void rewriteElementsWithEvenIndexes(int[] generatedNumbers) {
        int currentWritingIndex = 0;
        for (int currentReadingIndex = 0; currentReadingIndex < generatedNumbers.length; currentReadingIndex += 2) {
            generatedNumbers[currentWritingIndex] = generatedNumbers[currentReadingIndex];
            currentWritingIndex++;
        }
    }

}

