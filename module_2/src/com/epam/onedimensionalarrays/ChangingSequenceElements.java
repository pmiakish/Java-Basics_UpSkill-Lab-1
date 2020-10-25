package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class ChangingSequenceElements {
    public static void replaceElements() {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("\nSpecify the amount of the sequence numbers: ");
        int amountOfNumbers = console.nextInt();

        if (amountOfNumbers >= 1) {
            double[] doubleArray = ArrayMaker.getDoubleSequence(amountOfNumbers);
            System.out.println("\nThe sequence of " + amountOfNumbers + " real numbers has been generated:");
            ArrayReader.printDouble(doubleArray);

            System.out.print("\nEnter value 'Z' (must be less than the greatest number of the sequence): ");
            double z = console.nextDouble();
            if (z < doubleArray[doubleArray.length - 1]) {
                int numberOfReplacements = 0;
                System.out.println("\nThe sequence of real numbers has been modified:");
                for (int i = 0; i < doubleArray.length; i++) {
                    if (doubleArray[i] > z) {
                        doubleArray[i] = z;
                        numberOfReplacements++;
                    }
                    System.out.print(doubleArray[i] + " ");
                }
                System.out.println("\nNumber of replacements: " + numberOfReplacements);
            } else {
                System.out.println("Incorrect 'Z'-value! Try again...");
            }
        } else {
            System.out.print("Incorrect value! try again...");
        }
    }
    
}
