package com.epam.decompositionusingmethods;

import java.util.Arrays;
import com.epam.arraysofarrays.MatrixBuilder;
import com.epam.arraysofarrays.MatrixPrinter;
import com.epam.onedimensionalarrays.ArrayMaker;

public class TaskLauncher {

    // task 01
    private static final int NUMBER_A = 252;
    private static final int NUMBER_B = 27;

    // task 02
    private static final int NUMBER_C = 78;
    private static final int NUMBER_D = 294;
    private static final int NUMBER_E = 570;
    private static final int NUMBER_F = 36;

    // task 03
    private static final double SIDE_LENGTH = 8.0;

    // task 04
    private static final double MIN_COORDINATE_VALUE = -50.0;
    private static final double MAX_COORDINATE_VALUE = 50.0;
    private static final int NUMBER_OF_COORDINATE_AXES = 2;
    private static final int NUMBER_OF_POINTS = 6;

    // task 05
    private static final int MIN_VALUE_FIFTH_TASK = -35;
    private static final int MAX_VALUE_FIFTH_TASK = 35;
    private static final int AMOUNT_OF_NUMBERS_FIFTH_TASK = 20;

    // task 06
    private static final int FIRST_NUMBER_SIXTH_TASK = 91;
    private static final int SECOND_NUMBER_SIXTH_TASK = 27;
    private static final int THIRD_NUMBER_SIXTH_TASK = 133;

    // task 07
    private static final int FIRST_NUMBER_SEVENTH_TASK = 1;
    private static final int SECOND_NUMBER_SEVENTH_TASK = 9;

    public static void main(String[] args) {

        // task 01
        int divisorFirstTask = NumbersAnalyzer.findGreatestCommonDivisor(NUMBER_A, NUMBER_B);
        if (divisorFirstTask != -1) {
            System.out.println("\n--- TASK 01 ---\nThe greatest common divisor of numbers " + NUMBER_A + " and " +
                    NUMBER_B + " is " + divisorFirstTask);
            int multipleFirstTask = NumbersAnalyzer.findLeastCommonMultiple(NUMBER_A, NUMBER_B);
            System.out.println("The least common multiple of numbers " + NUMBER_A + " and " +
                    NUMBER_B + " is " + multipleFirstTask);
        } else {
            System.out.println("\n--- TASK 01 ---\nIncorrect parameters!");
        }

        // task 02
        int divisorSecondTask = NumbersAnalyzer.findGreatestCommonDivisor(NUMBER_C, NUMBER_D, NUMBER_E, NUMBER_F);
        if (divisorSecondTask != -1) {
            System.out.println("\n--- TASK 02 ---\nThe greatest common divisor of numbers " + NUMBER_C + ", " +
                    NUMBER_D + ", " + NUMBER_E + ", " + NUMBER_F + " is " + divisorSecondTask);
        } else {
            System.out.println("\n--- TASK 02 ---\nIncorrect parameters!");
        }

        // task 03
        double regularHexagonArea = GeometricalCalculator.findRegularHexagonArea(SIDE_LENGTH);
        if (regularHexagonArea != -1) {
            System.out.println("\n--- TASK 03 ---\nThe area of the regular hexagon with the side length " + SIDE_LENGTH
                    + " is " + regularHexagonArea);
        } else {
            System.out.println("\n--- TASK 03 ---\nIncorrect value of the side length!");
        }

        // task 04
        double[][] coordinates = MatrixBuilder.generateMatrix(MIN_COORDINATE_VALUE, MAX_COORDINATE_VALUE,
                NUMBER_OF_COORDINATE_AXES, NUMBER_OF_POINTS);
        System.out.println("\n--- TASK 04 ---\nThe generated coordinates (the first row - x, the second row - y):");
        MatrixPrinter.printMatrix(coordinates);
        int[] mostDistantPoints = GeometricalCalculator.findMostDistantPoints(coordinates);
        if (mostDistantPoints != null) {
            System.out.println("\nThe most distant points are " + Arrays.toString(mostDistantPoints) + " with " +
                    "coordinates: x1[" + coordinates[0][mostDistantPoints[0]] + "] y1[" +
                    coordinates[1][mostDistantPoints[0]] + "], x2[" + coordinates[0][mostDistantPoints[1]] + "] y2[" +
                    coordinates[1][mostDistantPoints[1]] + "]");
        } else {
            System.out.println("\n--- TASK 04 ---\nIncorrect coordinate values!");
        }

        // task 05
        int[] generatedNumbersForFifthTask = ArrayMaker.generateArray(MIN_VALUE_FIFTH_TASK, MAX_VALUE_FIFTH_TASK,
                AMOUNT_OF_NUMBERS_FIFTH_TASK);
        System.out.println("\n--- TASK 05 ---\nThe generated array:\n" + Arrays.toString(generatedNumbersForFifthTask));
        int secondLargestNumber = NumbersAnalyzer.findSecondLargestNumber(generatedNumbersForFifthTask);
        if (secondLargestNumber != Integer.MIN_VALUE) {
            System.out.println("The second largest number in the array is " + secondLargestNumber);
        } else {
            System.out.println("\n--- TASK 05 ---\nThe second largest number of the array not found!");
        }

        // task 06
        int resultOfChecking = NumbersAnalyzer.checkIfNumbersAreCoprime(FIRST_NUMBER_SIXTH_TASK,
                SECOND_NUMBER_SIXTH_TASK, THIRD_NUMBER_SIXTH_TASK);
        if (resultOfChecking == 1) {
            System.out.println("\n--- TASK 06 ---\nThe numbers " + FIRST_NUMBER_SIXTH_TASK + ", " +
                    SECOND_NUMBER_SIXTH_TASK + ", " + THIRD_NUMBER_SIXTH_TASK + " are coprime.");
        } else if (resultOfChecking == 0) {
            System.out.println("\n--- TASK 06 ---\nThe numbers " + FIRST_NUMBER_SIXTH_TASK + ", " +
                    SECOND_NUMBER_SIXTH_TASK + ", " + THIRD_NUMBER_SIXTH_TASK + " aren't coprime.");
        } else if (resultOfChecking == -1) {
            System.out.println("\n--- TASK 06 ---\nIncorrect values of the given numbers!");
        }

        // task 07
        long sumOfOddNumbersFactorials = NumbersAnalyzer.findSumOfOddNumbersFactorials(FIRST_NUMBER_SEVENTH_TASK,
                SECOND_NUMBER_SEVENTH_TASK);
        if (sumOfOddNumbersFactorials != -1) {
            System.out.println("\n--- TASK 07 ---\nThe sum of the all odd numbers from " + FIRST_NUMBER_SEVENTH_TASK +
                    " to " + SECOND_NUMBER_SEVENTH_TASK + " is " + sumOfOddNumbersFactorials);
        } else {
            System.out.println("\n--- TASK 07 ---\nIncorrect values of the given numbers!");
        }

    }
}
