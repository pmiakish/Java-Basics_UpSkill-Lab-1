package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class IntSequenceChanging {
    public static void removeMinElements() {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("\nSpecify the amount of the sequence numbers (more than or equals to 2): ");
        int amountOfNumbers = console.nextInt();

        if (amountOfNumbers >= 2) {
            int[] intArray = ArrayMaker.getIntSequence(amountOfNumbers);
            System.out.println("\nThe sequence of " + amountOfNumbers + " integer numbers has been generated:");
            ArrayReader.printInt(intArray);

            int minValue = intArray[0];
            int count = 1;
            for (int i = 1; i < intArray.length; i++) { // find min values
                if (intArray[i] < minValue) {
                    minValue = intArray[i];
                    count = 1;
                } else if (intArray[i] == minValue) {
                    count++;
                }
            }
            if (count < intArray.length) {
                int[] newIntArray = new int[intArray.length - count];
                int newIntArrayIndex = 0;
                for (int i : intArray) {
                    if (i != minValue) {
                        newIntArray[newIntArrayIndex] = i;
                        newIntArrayIndex++;
                    }
                }
                System.out.println("\nThe sequence without min elements:");
                ArrayReader.printInt(newIntArray);
            } else {
                System.out.println("The sequence contains the same elements!");
            }
        }
    }
}
