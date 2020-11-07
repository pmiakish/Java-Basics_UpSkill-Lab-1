package com.epam.decompositionusingmethods;

import com.epam.arraysofarrays.MatrixBuilder;
import com.epam.arraysofarrays.MatrixPrinter;

import java.util.Arrays;

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
    private static final int NUMBER_OF_POINTS = 4;

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
            System.out.println("The most distant points are " + Arrays.toString(mostDistantPoints) + " with " +
                    "coordinates: x1[" + coordinates[0][mostDistantPoints[0]] + "] y1[" +
                    coordinates[1][mostDistantPoints[0]] + "], x2[" + coordinates[0][mostDistantPoints[1]] + "] y2[" +
                    coordinates[1][mostDistantPoints[1]] + "]");
        } else {
            System.out.println("\n--- TASK 04 ---\nIncorrect coordinate values!");
        }

    }
}
