package com.epam.sorting;

import java.util.Arrays;
import com.epam.onedimensionalarrays.ArrayMaker;

public class TaskLauncher {

    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;
    private static final int SORT_AMOUNT_OF_NUMBERS = 100;
    private static final int FIRST_AMOUNT_OF_NUMBERS = 15;
    private static final int SECOND_AMOUNT_OF_NUMBERS = 10;
    private static final int K_PARAMETER = 7;

    public static void main(String[] args) {

        // task 01
        int[] firstArray = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, FIRST_AMOUNT_OF_NUMBERS);
        System.out.println("\n--- TASK 01 ---\nThe numbers of the first array are -> " + Arrays.toString(firstArray));
        int[] secondArray = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, SECOND_AMOUNT_OF_NUMBERS);
        System.out.println("The numbers of the second array are -> " + Arrays.toString(secondArray));
        int[] concatenatedArray = ArraysIntegrator.concatenateArrays(firstArray, secondArray, K_PARAMETER);
        if (concatenatedArray != null) {
            System.out.println("The numbers of the concatenated array are -> " + Arrays.toString(concatenatedArray));
        } else {
            System.out.println("Incorrect K-parameter!");
        }

        // task 02
        int[] firstArrayForSorting = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, SORT_AMOUNT_OF_NUMBERS);
        System.out.println("\n--- TASK 02 ---\nThe unsorted array -> " + Arrays.toString(firstArrayForSorting));
        int numberOfComparisons = ArraySorter.sortBySelection(firstArrayForSorting);
        System.out.println("The array after selection sorting -> " + Arrays.toString(firstArrayForSorting) +
                "\nThe number of comparisons is " + numberOfComparisons);

        // task 03
        int[] secondArrayForSorting = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, SORT_AMOUNT_OF_NUMBERS);
        System.out.println("\n--- TASK 03 ---\nThe unsorted array -> " + Arrays.toString(secondArrayForSorting));
        numberOfComparisons = ArraySorter.sortBySwapping(secondArrayForSorting);
        System.out.println("The array after swap sorting -> " + Arrays.toString(secondArrayForSorting) +
                "\nThe number of comparisons is " + numberOfComparisons);

        // task 04
        int[] thirdArrayForSorting = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, SORT_AMOUNT_OF_NUMBERS);
        System.out.println("\n--- TASK 04 ---\nThe unsorted array -> " + Arrays.toString(thirdArrayForSorting));
        numberOfComparisons = ArraySorter.sortByInsertion(thirdArrayForSorting);
        System.out.println("The array after insertion sorting -> " + Arrays.toString(thirdArrayForSorting) +
                "\nThe number of comparisons is " + numberOfComparisons);

        // task 05
        int[] fourthArrayForSorting = ArrayMaker.generateArray(MIN_VALUE, MAX_VALUE, SORT_AMOUNT_OF_NUMBERS);
        System.out.println("\n--- TASK 05 ---\nThe unsorted array -> " + Arrays.toString(fourthArrayForSorting));
        numberOfComparisons = ArraySorter.sortByShell(fourthArrayForSorting);
        System.out.println("The array after Shell sorting -> " + Arrays.toString(fourthArrayForSorting) +
                "\nThe number of comparisons is " + numberOfComparisons);

    }
}
