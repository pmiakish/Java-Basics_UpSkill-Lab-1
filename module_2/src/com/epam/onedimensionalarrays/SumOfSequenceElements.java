package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class SumOfSequenceElements {
    public static void addElementsWithPrimeIndexes() {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("\nSpecify the amount of the sequence numbers (more than or equals to 3): ");
        int amountOfNumbers = console.nextInt();

        if (amountOfNumbers >= 3) {
            double[] doubleArray = ArrayMaker.getDoubleSequence(amountOfNumbers);
            System.out.println("\nThe sequence of " + amountOfNumbers + " real numbers has been generated:");
            ArrayReader.printDouble(doubleArray);

            double sumOfElementsWithPrimeIndexes = 0.0;
            for (int i = 2; i < doubleArray.length; i++) {
                boolean isCompositeIndex = false;
                for (int divisor = 2; divisor <= Math.round(Math.sqrt(i)); divisor++) {
                    if (i % divisor == 0) {
                        isCompositeIndex = true;
                        break;
                    }
                }
                if (!isCompositeIndex) {
                    sumOfElementsWithPrimeIndexes += doubleArray[i];
                }
            }
            System.out.print("\nThe sum of the sequence elements which have prime-number indexes is " + sumOfElementsWithPrimeIndexes + ".");
        } else {
            System.out.print("Incorrect value! try again...");
        }
    }
}
