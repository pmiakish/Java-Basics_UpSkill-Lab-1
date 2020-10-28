package com.epam.onedimensionalarrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;

public class TaskLauncher {

    // Task 01
    private static final int MIN_VALUE_FIRST_TASK = 1;
    private static final int MAX_VALUE_FIRST_TASK = 50;
    private static final int AMOUNT_OF_NUMBERS_FIRST_TASK = 20;
    private static final int DIVISOR_K = 5;

    // Task 02
    private static final double START_VALUE_SECOND_TASK = 10.0;
    private static final double END_VALUE_SECOND_TASK = -10.0;
    private static final int AMOUNT_OF_NUMBERS_SECOND_TASK = 20;
    private static final double SPECIFIED_PARAMETER_Z = 5.65;

    // Task 03
    private static final double MIN_VALUE_THIRD_TASK = -30.0;
    private static final double MAX_VALUE_THIRD_TASK = 30.0;
    private static final int AMOUNT_OF_NUMBERS_THIRD_TASK = 30;

    // Task 04
    private static final double MIN_VALUE_FOURTH_TASK = -50.0;
    private static final double MAX_VALUE_FOURTH_TASK = 50.0;
    private static final int AMOUNT_OF_NUMBERS_FOURTH_TASK = 10;

    // Task 05
    private static final int MIN_VALUE_FIFTH_TASK = 1;
    private static final int MAX_VALUE_FIFTH_TASK = 50;
    private static final int AMOUNT_OF_NUMBERS_FIFTH_TASK = 30;

    // Task 06
    private static final double START_VALUE_SIXTH_TASK = 20.0;
    private static final double END_VALUE_SIXTH_TASK = -20.0;
    private static final int AMOUNT_OF_NUMBERS_SIXTH_TASK = 20;

    // Task 08
    private static final int AMOUNT_OF_NUMBERS_EIGHTH_TASK = 20;

    // Task 09
    private static final int MIN_VALUE_NINTH_TASK = -25;
    private static final int MAX_VALUE_NINTH_TASK = 50;
    private static final int AMOUNT_OF_NUMBERS_NINTH_TASK = 30;

    // Task 10
    private static final int MIN_VALUE_TENTH_TASK = -25;
    private static final int MAX_VALUE_TENTH_TASK = 50;
    private static final int AMOUNT_OF_NUMBERS_TENTH_TASK = 30;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Module 2. Algorithmization. One-dimensional arrays");
        System.out.print("Enter the task number: ");
        int taskNumber = console.nextInt();

        // Tasks
        switch (taskNumber) {
            case 1:
                int[] generatedIntNumbersForSumming = ArrayMaker.generateArrayOfIntNumbers(MIN_VALUE_FIRST_TASK, MAX_VALUE_FIRST_TASK, AMOUNT_OF_NUMBERS_FIRST_TASK);
                System.out.println("\nThe generated array:\n" + Arrays.toString(generatedIntNumbersForSumming));
                int sum = SumCalculatorOfNumbersDivisibleByK.countSum(generatedIntNumbersForSumming, DIVISOR_K);
                if (sum > 0) {
                    System.out.println("\nThe sum of the numbers divisible by K is " + sum);
                }
                break;
            case 2:
                double[] generatedSequence = ArrayMaker.generateSequenceOfRealNumbers(START_VALUE_SECOND_TASK, END_VALUE_SECOND_TASK, AMOUNT_OF_NUMBERS_SECOND_TASK);
                System.out.println("\nThe generated sequence:\n" + Arrays.toString(generatedSequence));
                generatedSequence = SequenceElementsGreaterThanZChanger.replaceElements(generatedSequence, SPECIFIED_PARAMETER_Z);
                if (generatedSequence != null) {
                    System.out.println("\nThe modified sequence (all the elements greater than Z have been replaced with Z-value):\n" + Arrays.toString(generatedSequence));
                }
                break;
            case 3:
                double[] generatedNumbersForAnalysis = ArrayMaker.generateArrayOfRealNumbers(MIN_VALUE_THIRD_TASK, MAX_VALUE_THIRD_TASK, AMOUNT_OF_NUMBERS_THIRD_TASK);
                System.out.println("\nThe generated array:\n" + Arrays.toString(generatedNumbersForAnalysis));
                System.out.print("\nThe array contains (positive numbers, negative numbers, zeros) :" + Arrays.toString(RealNumbersArrayAnalyser.characterizeArray(generatedNumbersForAnalysis)));
                break;
            case 4:
                double[] generatedNumbersForMaxMinSwapping = ArrayMaker.generateArrayOfRealNumbers(MIN_VALUE_FOURTH_TASK, MAX_VALUE_FOURTH_TASK, AMOUNT_OF_NUMBERS_FOURTH_TASK);
                System.out.println("\nThe generated array:\n" + Arrays.toString(generatedNumbersForMaxMinSwapping));
                generatedNumbersForMaxMinSwapping = RealNumbersMaxMinElementsSwapper.swapElements(generatedNumbersForMaxMinSwapping);
                if (generatedNumbersForMaxMinSwapping != null) {
                    System.out.println("\nThe modified array (max and min elements has been swapped):\n" + Arrays.toString(generatedNumbersForMaxMinSwapping));
                }
                break;
            case 5:
                int[] generatedNumbersForSelectivePrint = ArrayMaker.generateArrayOfIntNumbers(MIN_VALUE_FIFTH_TASK, MAX_VALUE_FIFTH_TASK, AMOUNT_OF_NUMBERS_FIFTH_TASK);
                System.out.println("\nThe generated array:\n" + Arrays.toString(generatedNumbersForSelectivePrint));
                PrinterOfNumbersGreaterThanTheirIndexes.printValues(generatedNumbersForSelectivePrint);
                break;
            case 6:
                double[] generatedRealNumbersForSumming = ArrayMaker.generateSequenceOfRealNumbers(START_VALUE_SIXTH_TASK, END_VALUE_SIXTH_TASK, AMOUNT_OF_NUMBERS_SIXTH_TASK);
                System.out.println("\nThe generated sequence:\n" + Arrays.toString(generatedRealNumbersForSumming));
                System.out.println("\nThe sum of the elements which indexes are prime numbers is " + SumCalculatorOfSequenceElementsWithPrimeIndexes.countSum(generatedRealNumbersForSumming));
                break;
            case 8:
                int[] generatedIntNumbersForRemovingMinElements = ArrayMaker.generateSequenceOfIntNumbers(AMOUNT_OF_NUMBERS_EIGHTH_TASK);
                System.out.println("\nThe generated sequence:\n" + Arrays.toString(generatedIntNumbersForRemovingMinElements));
                generatedIntNumbersForRemovingMinElements = MinValueSequenceElementsRemover.removeElements(generatedIntNumbersForRemovingMinElements);
                if (generatedIntNumbersForRemovingMinElements != null) {
                    System.out.println("\nThe modified array (min elements have been removed):\n" + Arrays.toString(generatedIntNumbersForRemovingMinElements));
                }
                break;
            case 9:
                int[] generatedNumbersForSearchingMostFrequentElement = ArrayMaker.generateArrayOfIntNumbers(MIN_VALUE_NINTH_TASK, MAX_VALUE_NINTH_TASK, AMOUNT_OF_NUMBERS_NINTH_TASK);
                System.out.println("\nThe generated array:\n" + Arrays.toString(generatedNumbersForSearchingMostFrequentElement));
                int index = IntArrayMinOfMostFrequentElementsFinder.findElement(generatedNumbersForSearchingMostFrequentElement);
                if (index != -1) {
                    System.out.println("\nThe min value of the most frequent elements in the array is " + generatedNumbersForSearchingMostFrequentElement[index]);
                }
                break;
            case 10:
                int[] generatedIntNumbersForOptimization = ArrayMaker.generateArrayOfIntNumbers(MIN_VALUE_TENTH_TASK, MAX_VALUE_TENTH_TASK, AMOUNT_OF_NUMBERS_TENTH_TASK);
                System.out.println("\nThe generated array:\n" + Arrays.toString(generatedIntNumbersForOptimization));
                System.out.println("\nThe modified array:\n" + Arrays.toString(EachSecondElementOfArrayCompressor.compressArray(generatedIntNumbersForOptimization)));
                break;
            default:
                System.out.println("Task " + taskNumber + " not found");
                break;
        }
    }
}
