package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class IntArrayElementsCompressing {
    public static void compressArray() {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\nSpecify the array parameters (including integer numbers): ");
        System.out.print("- min value: ");
        int minValue = console.nextInt();
        System.out.print("- max value: ");
        int maxValue = console.nextInt();
        System.out.print("- amount of numbers (more than or equal to 2): ");
        int amountOfNumbers = console.nextInt();

        if (maxValue > minValue && amountOfNumbers >= 2) {
            int[] integerArray = ArrayMaker.getIntArray(minValue, maxValue, amountOfNumbers);
            System.out.println("\nThe array has been generated:");
            ArrayReader.printInt(integerArray);

            // rewriting array values which have even indexes
            int currentWritingIndex = 0;
            for (int i = 0; i < integerArray.length; i++) {
                if (i % 2 == 0) {
                    integerArray[currentWritingIndex] = integerArray[i];
                    currentWritingIndex++;
                }
            }
            // emptied elements optimization
            for (int j = currentWritingIndex; j < integerArray.length; j++) {
                integerArray[j] = 0;
                }
            System.out.println("\nThe array has been compressed:");
            ArrayReader.printInt(integerArray);

        } else {
            System.out.print("Incorrect values! try again...");
        }
    }
}
