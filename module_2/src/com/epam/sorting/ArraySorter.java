package com.epam.sorting;

public class ArraySorter {

    public static int sortBySelection(int[] array) {
        int temp;
        int counterOfComparisons = 0;
        for (int i = 1; i < array.length; i++) {
            int indexOfMinValue = i - 1;
            for (int j = i; j < array.length; j++) {
                counterOfComparisons++;
                if (array[j] < array[indexOfMinValue]) {
                    indexOfMinValue = j;
                }
            }
            temp = array[i - 1];
            array[i - 1] = array[indexOfMinValue];
            array[indexOfMinValue] = temp;
        }
        return counterOfComparisons;
    }

    public static int sortBySwapping(int[] array) {
        int temp;
        int counterOfComparisons = 0;
        boolean isArrayUnsorted;
        for (int i = 0; i < array.length; i++) {
            isArrayUnsorted = false;
            int lastIndex = array.length - i;
            for (int j = 1; j < lastIndex; j++) {
                counterOfComparisons++;
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    isArrayUnsorted = true;
                }
            }
            if (!isArrayUnsorted) {
                break;
            }
        }
        return counterOfComparisons;
    }

    public static int sortByInsertion(int[] array) {
        int temp;
        int counterOfComparisons = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                counterOfComparisons++;
                temp = array[i];
                for (int j = i - 1; j >= 0; j--) {
                    counterOfComparisons++;
                    if (array[j] > temp && j != 0) {
                        array[j + 1] = array[j];
                    } else if (array[j] > temp && j == 0) {
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                    else {
                        array[j + 1] = temp;
                        break;
                    }
                }
            }
        }
        return counterOfComparisons;
    }

    public static int sortByShell(int[] array) {
        int temp;
        int counterOfComparisons = 0;
        int h = 1;
        while (h < array.length) {
            h = (h * 3) + 1;
        }
        while (h >= 1) {
            for (int j = 0; j + h < array.length; j++) {
                counterOfComparisons++;
                if (array[j] > array[j + h]) {
                    temp = array[j];
                    array[j] = array[j + h];
                    array[j + h] = temp;
                }
            }
            h /= 3;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                counterOfComparisons++;
                temp = array[i];
                for (int j = i - 1; j >= 0; j--) {
                    counterOfComparisons++;
                    if (array[j] > temp && j != 0) {
                        array[j + 1] = array[j];
                    } else if (array[j] > temp && j == 0) {
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                    else {
                        array[j + 1] = temp;
                        break;
                    }
                }
            }
        }
        return counterOfComparisons;
    }
}
