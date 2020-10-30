package com.epam.onedimensionalarrays;

/**
 * Task #9:
 * The class for searching the min value of the most frequent
 * elements of the integer array.
 */

public class IntArrayMinOfMostFrequentElementsFinder {

    public static int findElement(int[] generatedNumbers) {
        int[] elementsFrequencyArray = createArrayOfElementsFrequency(generatedNumbers);
        int indexOfMaxFrequentlyValue = -1;
        if (elementsFrequencyArray != null) {
            int maxFrequency = elementsFrequencyArray[0];
            int maxFrequentlyValue = generatedNumbers[0];

            for (int currentIndex = 1; currentIndex < elementsFrequencyArray.length; currentIndex++) {
                if (elementsFrequencyArray[currentIndex] > maxFrequency) {
                    maxFrequency = elementsFrequencyArray[currentIndex];
                    maxFrequentlyValue = generatedNumbers[currentIndex];
                    indexOfMaxFrequentlyValue = currentIndex;
                } else if (elementsFrequencyArray[currentIndex] == maxFrequency) {
                    // checking if the value of current element is the smallest
                    if (generatedNumbers[currentIndex] < maxFrequentlyValue) {
                        maxFrequentlyValue = generatedNumbers[currentIndex];
                        indexOfMaxFrequentlyValue = currentIndex;
                    }
                }
            }
            if (maxFrequency == 1) {
                indexOfMaxFrequentlyValue = -1;
            }
        }
        return indexOfMaxFrequentlyValue;
    }

    private static int[] createArrayOfElementsFrequency(int[] generatedNumbers) {
        int[] elementsFrequencyArray = new int[generatedNumbers.length];
        int amountOfUniqueElements = 0;
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
                for (int continuationIndex = currentIndex + 1; continuationIndex < generatedNumbers.length;
                        continuationIndex++) {
                    if (generatedNumbers[continuationIndex] == generatedNumbers[currentIndex]) {
                        elementsFrequencyArray[currentIndex]++;
                    }
                }
            } else {
                elementsFrequencyArray[currentIndex] = -1; // if the element has been already found in the array
            }
        }
        return (amountOfUniqueElements == 1) ? null : elementsFrequencyArray;
    }
}

