package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class IntArrayIndexValue {
    public static void getValues () {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("\nSpecify the array parameters (including only natural numbers): ");
        System.out.print("- min value: ");
        int minValue = console.nextInt();
        System.out.print("- max value: ");
        int maxValue = console.nextInt();
        System.out.print("- amount of numbers: ");
        int amountOfNumbers = console.nextInt();

        if (maxValue > minValue && amountOfNumbers >= 1) {
            int[] integerArray = ArrayMaker.getIntArray(minValue, maxValue, amountOfNumbers);
            System.out.println("\nThe array has been generated:");
            ArrayReader.printInt(integerArray);

            System.out.println("The array elements with a value greater than index: ");
            for (int i = 0; i < integerArray.length; i++) {
                if (integerArray[i] > i) {
                    System.out.print("[" + integerArray[i] + ", ind " + i + "] ");
                }
            }

        } else {
            System.out.print("Incorrect values! try again...");
        }
    }
}
