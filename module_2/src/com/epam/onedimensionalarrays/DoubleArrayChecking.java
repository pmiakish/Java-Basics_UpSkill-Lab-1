package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class DoubleArrayChecking {
    public static void checkElements () {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("\nSpecify the array parameters (including real numbers): ");
        System.out.print("- min value: ");
        double minValue = console.nextDouble();
        System.out.print("- max value: ");
        double maxValue = console.nextDouble();
        System.out.print("- amount of numbers: ");
        int amountOfNumbers = console.nextInt();

        if (minValue < maxValue && amountOfNumbers >= 1) {
            double[] doubleArray = ArrayMaker.getDoubleArray(minValue, maxValue, amountOfNumbers);
            System.out.println("\nThe array has been generated:");
            ArrayReader.printDouble(doubleArray);

            int countPositiveNumbers = 0;
            int countNegativeNumbers = 0;
            int countZeroNumbers = 0;
            for (double d : doubleArray) {
                 if (d > 0) {
                     countPositiveNumbers++;
                 } else if (d < 0) {
                     countNegativeNumbers++;
                 } else {
                     countZeroNumbers++;
                 }
            }
            System.out.println("Total amount of positive numbers - " + countPositiveNumbers + ", negative numbers - " + countNegativeNumbers + ", zero numbers - " + countZeroNumbers + ".");
        } else {
            System.out.print("Incorrect values! try again...");
        }
    }
}
