package com.epam.onedimensionalarrays;

import java.util.Scanner;
import java.util.Locale;

public class SumOfNumbersDivisibleByK {
    public static void getSum () {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("\nSpecify the array parameters (including only natural numbers): ");
        System.out.print("- min value: ");
        int minValue = console.nextInt();
        System.out.print("- max value: ");
        int maxValue = console.nextInt();
        System.out.print("- amount of numbers: ");
        int amountOfNumbers = console.nextInt();
        System.out.print("Specify the 'K'-value (must be less than or equal to " + maxValue + "): ");
        int k = console.nextInt();

        if (minValue >= 1 && maxValue > minValue && k <= maxValue && amountOfNumbers >= 1) {
            int[] integerArray = ArrayMaker.getIntArray(minValue, maxValue, amountOfNumbers);
            System.out.println("\nThe array has been generated:");
            ArrayReader.printInt(integerArray);
            System.out.print("Sum of the array numbers that are divisible by " + k + " = ");
            int sum = 0;
            for (int i : integerArray) {
                if ((i % k) == 0) {
                    sum += i;
                }
            }
            System.out.print(sum);
        } else {
            System.out.print("Incorrect values! try again...");
        }
    }
}
