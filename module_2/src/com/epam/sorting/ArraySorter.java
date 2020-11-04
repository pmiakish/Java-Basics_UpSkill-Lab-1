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
        System.out.println("The sorted array (by select) -> " + Arrays.toString(sortBySelect(unsortedArray)));

    }

    private static int[] sortBySelect(int[] unsortedArray) {
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
}
