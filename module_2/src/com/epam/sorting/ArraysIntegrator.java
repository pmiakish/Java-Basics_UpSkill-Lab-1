package com.epam.sorting;

import java.util.Arrays;
import com.epam.onedimensionalarrays.ArrayMaker;

public class ArraysIntegrator {

    private static final int MIN_VALUE = -25;
    private static final int MAX_VALUE = 25;
    private static final int FIRST_AMOUNT_OF_NUMBERS = 15;
    private static final int SECOND_AMOUNT_OF_NUMBERS = 10;
    private static final int K_PARAMETER = 7;

    public static void main(String[] args) {
        int[] firstArray = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, FIRST_AMOUNT_OF_NUMBERS);
        System.out.println("The numbers of the first array are -> " + Arrays.toString(firstArray));
        int[] secondArray = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, SECOND_AMOUNT_OF_NUMBERS);
        System.out.println("The numbers of the second array are -> " + Arrays.toString(secondArray));
        if (K_PARAMETER > 0 && K_PARAMETER < firstArray.length - 1) {
            int[] concatenatedArray = new int[firstArray.length + secondArray.length];
            insertArrayToArray(firstArray, secondArray, concatenatedArray);
            System.out.println("\nThe numbers of the concatenated array are -> " + Arrays.toString(concatenatedArray));
        } else {
            System.out.println("Incorrect K-parameter!");
        }
    }

    private static void insertArrayToArray(int[] firstArray, int[] secondArray, int[] concatenatedArray) {
        int endOfSecondArrayWriting = K_PARAMETER + secondArray.length;
        int continuationOfFirstArrayWriting = K_PARAMETER + 1;
        int currentIndexOfSecondArray = 0;
        for (int i = 0; i < concatenatedArray.length; i++) {
            if (i <= K_PARAMETER) {
                concatenatedArray[i] = firstArray[i];
            } else if (i > K_PARAMETER && i <= endOfSecondArrayWriting) {
                concatenatedArray[i] = secondArray[currentIndexOfSecondArray++];
            } else {
                concatenatedArray[i] = firstArray[continuationOfFirstArrayWriting++];
            }
        }
    }
}
