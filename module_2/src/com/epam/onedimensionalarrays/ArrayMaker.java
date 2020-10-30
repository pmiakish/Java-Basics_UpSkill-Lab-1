package com.epam.onedimensionalarrays;

public class ArrayMaker {

    // Random integer array with max and min values
    public static int[] generateArray(int minValue, int maxValue, int amountOfNumbers) {
        int[] generatedArray = new int[amountOfNumbers];
        for (int i  = 0; i < amountOfNumbers; i++) {
            generatedArray[i] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        }
        return generatedArray;
    }

    // Random double array with max and min values
    public static double[] generateArray(double minValue, double maxValue, int amountOfNumbers) {
        double[] generatedArray = new double[amountOfNumbers];
        for (int i  = 0; i < amountOfNumbers; i++) {
            generatedArray[i] = Math.random() * (maxValue - minValue) + minValue;
        }
        return generatedArray;
    }

    // Random int sequence with amount of numbers
    public static int[] generateSequenceOfIntNumbers(int amountOfNumbers) {
        int a = (int) ((Math.random() - Math.random()) * 10.0);
        int b = (int) ((Math.random() - Math.random()) * 10.0);
        int c = (int) ((Math.random() - Math.random()) * 10.0);
        while (b == 0 || c == 0) {
            b += (int) ((Math.random() - Math.random()) * 10.0);
            c += (int) ((Math.random() - Math.random()) * 10.0);
        }
        int[] generatedSequence = new int[amountOfNumbers];
        generatedSequence[0] =  (b * c) + a;
        for (int currentIndex = 1; currentIndex < amountOfNumbers; currentIndex++) {
            generatedSequence[currentIndex] =  generatedSequence[currentIndex - 1] + (b * c) + a;
        }
        return generatedSequence;
    }

    // Random double sequence with start and end values
    public static double[] generateSequenceOfRealNumbers(double startValue, double endValue,
            int amountOfNumbers) {
        double[] generatedSequence = new double[amountOfNumbers];
        generatedSequence[0] = startValue;
        generatedSequence[amountOfNumbers - 1] = endValue;
        if (startValue > endValue) {
            for (int i = 1; i < amountOfNumbers; i++) {
                generatedSequence[i] = generatedSequence[i - 1] - ((startValue - endValue) /
                        (amountOfNumbers - 1));
            }
        } else if (startValue < endValue) {
            for (int i = 1; i < amountOfNumbers; i++) {
                generatedSequence[i] = generatedSequence[i - 1] + ((endValue - startValue) /
                        (amountOfNumbers - 1));
            }
        } else {
            System.out.println("\nIncorrect max/min values of the sequence!");
        }
        return generatedSequence;
    }

}
