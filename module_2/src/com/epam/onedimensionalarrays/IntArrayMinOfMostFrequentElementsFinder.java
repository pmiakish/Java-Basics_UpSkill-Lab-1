package com.epam.onedimensionalarrays;

import java.util.Arrays;

/**
 * Task #9:
 * The class for searching the min value of the most frequent
 * elements of the integer array.
 */

public class IntArrayMinOfMostFrequentElementsFinder {

    private static int amountOfUniqueElements = 0;

    public static int findElement(int[] generatedNumbers) {
        int[] elementsFrequencyArray = createArrayOfElementsFrequency(generatedNumbers);

        int maxFrequency = elementsFrequencyArray[0];
        int maxFrequentlyValue = generatedNumbers[0];
        int indexOfMaxFrequentlyValue = 0;

        for (int currentIndex = 1; currentIndex < elementsFrequencyArray.length; currentIndex++) {
            if (elementsFrequencyArray[currentIndex] > maxFrequency) {
                maxFrequency = elementsFrequencyArray[currentIndex];
                maxFrequentlyValue = generatedNumbers[currentIndex];
                indexOfMaxFrequentlyValue = currentIndex;
            } else if (elementsFrequencyArray[currentIndex] == maxFrequency) {
                if (generatedNumbers[currentIndex] < maxFrequentlyValue) { // checking if the value of current element is the smallest
                    maxFrequentlyValue = generatedNumbers[currentIndex];
                    indexOfMaxFrequentlyValue = currentIndex;
                }
            }
        }
        if (maxFrequency == 1 || amountOfUniqueElements == 1) {
            System.out.println("\nThe most frequently value of the array not found!");
            indexOfMaxFrequentlyValue = -1;
        }
        return indexOfMaxFrequentlyValue;
    }

    private static int[] createArrayOfElementsFrequency(int[] generatedNumbers) {
        int[] elementsFrequencyArray = new int[generatedNumbers.length];
        for (int currentIndex = 0; currentIndex < generatedNumbers.length; currentIndex++) {
            boolean isUniqueElement = true;
            for (int i = 0; i < currentIndex; i++) {
                if (generatedNumbers[i] == generatedNumbers[currentIndex]) {
                    isUniqueElement = false; // if the element is in the previously checked part of the array
                    break;
                }
            }
            if (isUniqueElement) {
                amountOfUniqueElements++;
                elementsFrequencyArray[currentIndex] = 1;
                for (int continuationIndex = currentIndex + 1; continuationIndex < generatedNumbers.length; continuationIndex++) {
                    if (generatedNumbers[continuationIndex] == generatedNumbers[currentIndex]) {
                        elementsFrequencyArray[currentIndex]++;
                    }
                }
            } else {
                elementsFrequencyArray[currentIndex] = -1; // if the element has been already found in the array
            }
        }
        return elementsFrequencyArray;
    }
}

