package com.epam.onedimensionalarrays;

/**
 * Task #4:
 * The class for swapping the min and max elements in the array of real numbers
 */

public class RealNumbersMaxMinElementsSwapper {

    private static int maxIndex = 0;
    private static int minIndex = 0;
    private static boolean multipleMaxIndex = false;
    private static boolean multipleMinIndex = false;

    public static double[] swapElements(double[] generatedNumbers) {
        searchForMaxMinElements(generatedNumbers);
        if (multipleMaxIndex || multipleMinIndex) {
            generatedNumbers = null;
            System.out.println("\nMultiple max or min values!");
        } else {
            double temporary = generatedNumbers[maxIndex];
            generatedNumbers[maxIndex] = generatedNumbers[minIndex];
            generatedNumbers[minIndex] = temporary;
        }
        return generatedNumbers;
    }

    private static void searchForMaxMinElements (double[] generatedNumbers) {
        for (int currentIndex = 1; currentIndex < generatedNumbers.length; currentIndex++) {
            // searching for max number
            if (generatedNumbers[currentIndex] > generatedNumbers[maxIndex]) {
                maxIndex = currentIndex;
                multipleMaxIndex = false;
            } else if (generatedNumbers[currentIndex] == generatedNumbers[maxIndex]) {
                multipleMaxIndex = true;
            }
            // searching for min number
            if (generatedNumbers[currentIndex] < generatedNumbers[minIndex]) {
                minIndex = currentIndex;
                multipleMinIndex = false;
            } else if (generatedNumbers[currentIndex] == generatedNumbers[minIndex]) {
                multipleMinIndex = true;
            }
        }
    }
}
