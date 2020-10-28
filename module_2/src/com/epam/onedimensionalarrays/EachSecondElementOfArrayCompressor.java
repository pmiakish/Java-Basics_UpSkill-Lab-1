package com.epam.onedimensionalarrays;

/**
 * Task #10:
 * The class for optimizing integer array elements
 * (compression of each second element, filling emptied elements with zeros).
 */;

public class EachSecondElementOfArrayCompressor {

    private static int currentWritingIndex = 0;

    public static int[] compressArray(int[] generatedNumbers) {
        generatedNumbers = rewriteElementsWithEvenIndexes(generatedNumbers);
        for (int i = currentWritingIndex; i < generatedNumbers.length; i++) {
            generatedNumbers[i] = 0;
        }
        return generatedNumbers;
    }

    private static int[] rewriteElementsWithEvenIndexes(int[] generatedNumbers) {
        for (int currentReadingIndex = 0; currentReadingIndex < generatedNumbers.length; currentReadingIndex++) {
            if (currentReadingIndex % 2 == 0) {
                generatedNumbers[currentWritingIndex] = generatedNumbers[currentReadingIndex];
                currentWritingIndex++;
            }
        }
        return generatedNumbers;
    }

}

