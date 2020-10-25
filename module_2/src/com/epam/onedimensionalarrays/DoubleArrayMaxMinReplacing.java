package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class DoubleArrayMaxMinReplacing {
    public static void repalceElements() {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("\nSpecify the array parameters (including real numbers): ");
        System.out.print("- min value: ");
        double minValue = console.nextDouble();
        System.out.print("- max value: ");
        double maxValue = console.nextDouble();
        System.out.print("- amount of numbers (more than or equals to 2): ");
        int amountOfNumbers = console.nextInt();

        if (minValue < maxValue && amountOfNumbers >= 2) {
            double[] doubleArray = ArrayMaker.getDoubleArray(minValue, maxValue, amountOfNumbers);
            System.out.println("\nThe array has been generated:");
            ArrayReader.printDouble(doubleArray);

            int maxIndex = 0;
            int minIndex = 0;
            for (int i = 1; i < doubleArray.length; i++) {
                 if (doubleArray[i] > doubleArray[maxIndex]) {
                     maxIndex = i;
                 }
                 if (doubleArray[i] < doubleArray[minIndex]) {
                     minIndex = i;
                 }
            }
            double tempValue = doubleArray[minIndex];
            doubleArray[minIndex] = doubleArray[maxIndex];
            doubleArray[maxIndex] = tempValue;
            System.out.println("The array has been modified (the min and max elements replaced):");
            ArrayReader.printDouble(doubleArray);
        } else {
            System.out.print("Incorrect values! try again...");
        }
    }
}
