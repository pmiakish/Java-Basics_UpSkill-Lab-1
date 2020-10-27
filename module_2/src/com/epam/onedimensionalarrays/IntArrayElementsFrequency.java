package com.epam.onedimensionalarrays;

import java.util.Locale;
import java.util.Scanner;

public class IntArrayElementsFrequency {
    public static void getMostFrequentElement() {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("\nSpecify the array parameters (including integer numbers): ");
        System.out.print("- min value: ");
        int minValue = console.nextInt();
        System.out.print("- max value: ");
        int maxValue = console.nextInt();
        System.out.print("- amount of numbers (more than or equal to 3): ");
        int amountOfNumbers = console.nextInt();

        if (maxValue > minValue && amountOfNumbers >= 3) {
            int[] integerArray = ArrayMaker.getIntArray(minValue, maxValue, amountOfNumbers);
            System.out.println("\nThe array has been generated:");
            ArrayReader.printInt(integerArray);

            // creating the array with frequencies of the elements
            int[] integerArrayElementsFrequency = new int[amountOfNumbers];
            int countUniqueElements = 0;
            for (int i = 0; i < integerArray.length; i++) {
                boolean isUniqueElement = true;
                for (int j = 0; j < i; j++) {
                    if (integerArray[j] == integerArray[i]) {
                        isUniqueElement = false;
                        break;
                    }
                }
                if (isUniqueElement) {
                    countUniqueElements++;
                    integerArrayElementsFrequency[i] = 1;
                    for (int currentIndex = i + 1; currentIndex < integerArray.length; currentIndex++) {
                        if (integerArray[currentIndex] == integerArray[i]) {
                            integerArrayElementsFrequency[i]++;
                        }
                    }
                } else {
                    integerArrayElementsFrequency[i] = 0; // if the element has been already found in the array
                }
            }

            // checking the array for the most frequently values
            int maxFrequency = integerArrayElementsFrequency[0];
            int maxFrequencyValue = integerArray[0];
            for (int i = 1; i < integerArrayElementsFrequency.length; i++) {
                if (integerArrayElementsFrequency[i] > maxFrequency) {
                    maxFrequency = integerArrayElementsFrequency[i];
                    maxFrequencyValue = integerArray[i];
                } else if (integerArrayElementsFrequency[i] == maxFrequency) {
                    if (integerArray[i] < maxFrequencyValue) {
                        maxFrequencyValue = integerArray[i];
                    }
                }
            }

            if (maxFrequency > 1 && countUniqueElements > 1) {
                System.out.println("The most frequently min value of the array is " + maxFrequencyValue + " (has been found " + maxFrequency + " times).");
            } else {
                System.out.println("The most frequently value of the array not found.");
            }

        } else {
            System.out.print("Incorrect values! try again...");
        }
    }
}
