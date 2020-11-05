package com.epam.sorting;

import java.util.Arrays;
import com.epam.onedimensionalarrays.ArrayMaker;

public class ArraySorter {

    private static final int MIN_VALUE = -50;
    private static final int MAX_VALUE = 50;
    private static final int AMOUNT_OF_NUMBERS = 20;

    public static void main(String[] args) {
        int[] unsortedArray = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, AMOUNT_OF_NUMBERS);
        System.out.println("The unsorted array -> " + Arrays.toString(unsortedArray));
        System.out.println("\nThe sorted array (by selection) -> " + Arrays.toString(sortBySelection(unsortedArray)));
        System.out.println("\nThe sorted array (by swapping) -> " + Arrays.toString(sortBySwapping(unsortedArray)));

    }

    private static int[] sortBySelection(int[] unsortedArray) {
        int[] arrayForSorting = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int temp;
        for (int i = 1; i < arrayForSorting.length; i++) {
            int indexOfMinValue = i - 1;
            for (int j = i; j < arrayForSorting.length; j++) {
                if (arrayForSorting[j] < arrayForSorting[indexOfMinValue]) {
                    indexOfMinValue = j;
                }
            }
            temp = arrayForSorting[i - 1];
            arrayForSorting[i - 1] = arrayForSorting[indexOfMinValue];
            arrayForSorting[indexOfMinValue] = temp;
        }
        return arrayForSorting;
    }

    private static int[] sortBySwapping(int[] unsortedArray) {
        int[] arrayForSorting = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int temp;
        boolean isArrayUnsorted;
        for (int i = 0; i < arrayForSorting.length; i++) {
            isArrayUnsorted = false;
            int lastIndex = arrayForSorting.length - i;
            for (int j = 1; j < lastIndex; j++) {
                if (arrayForSorting[j - 1] > arrayForSorting[j]) {
                    temp = arrayForSorting[j - 1];
                    arrayForSorting[j - 1] = arrayForSorting[j];
                    arrayForSorting[j] = temp;
                    isArrayUnsorted = true;
                }
            }
            if (!isArrayUnsorted) {
                break;
            }
        }
        return arrayForSorting;
    }

}
