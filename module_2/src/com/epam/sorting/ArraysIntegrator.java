package com.epam.sorting;

public class ArraysIntegrator {

    public static int[] concatenateArrays(int[] firstArray, int[] secondArray, int insertionIndex) {
        int[] concatenatedArray = null;
        if (insertionIndex > 0 && insertionIndex < firstArray.length - 1) {
            concatenatedArray = new int[firstArray.length + secondArray.length];
            int indexOfWriting = 0;
            for (int i = 0; i <= insertionIndex; i++) {
                concatenatedArray[indexOfWriting++] = firstArray[i];
            }
            for (int i = 0; i < secondArray.length; i++) {
                concatenatedArray[indexOfWriting++] = secondArray[i];
            }
            for (int i = insertionIndex + 1; i < firstArray.length; i++) {
                concatenatedArray[indexOfWriting++] = firstArray[i];
            }
        }
        return concatenatedArray;
    }
}
