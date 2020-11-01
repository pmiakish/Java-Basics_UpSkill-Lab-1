package com.epam.arrraysofarrays;

import static java.lang.Math.sin;

public class MatrixBuilder {

    // Random integer matrix with max, min values, predetermined numbers of rows and columns
    public static int[][] generateMatrix(int minValue, int maxValue, int numberOfRows, int numberOfColumns) {
        int[][] matrix = null;
        if (minValue < maxValue && numberOfRows > 1 && numberOfColumns > 1) {
            matrix = new int[numberOfRows][numberOfColumns];
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    matrix[i][j] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
                }
            }
        }
        return matrix;
    }

    // Random NON-NEGATIVE integer matrix with max, min values, predetermined numbers of rows and columns
    public static int[][] generateNonNegativeMatrix(int minValue, int maxValue, int numberOfRows, int numberOfColumns) {
        int[][] matrix = null;
        if (minValue >= 0 && minValue < maxValue && numberOfRows > 1 && numberOfColumns > 1) {
            matrix = new int[numberOfRows][numberOfColumns];
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    matrix[i][j] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
                }
            }
        }
        return matrix;
    }

    //task_04 build the square matrix according to a preassigned pattern: row_1 [1, 2, 3 ... n],
    //row_2 [n, n-1, n-2 ... 1], row_3 [1, 2, 3 ... n], row_n [n, n-1, n-2 ... 1]
    //N is an even number.
    public static int[][] buildMatrixAccordingToPattern1(int orderOfMatrix) {
        int[][] matrix = null;
        boolean isOrderOfMatrixEvenNumber = orderOfMatrix % 2 == 0;
        if (orderOfMatrix > 1 && isOrderOfMatrixEvenNumber) {
            matrix = new int[orderOfMatrix][orderOfMatrix];
            for (int i = 0; i < orderOfMatrix; i++) {
                boolean isOddRow = i % 2 == 0;
                if (isOddRow) {
                    for (int j = 0; j < orderOfMatrix; j++) {
                        matrix[i][j] = j + 1;
                    }
                } else {
                    for (int j = 0; j < orderOfMatrix; j++) {
                        matrix[i][j] = orderOfMatrix - j;
                    }
                }
            }
        }
        return matrix;
    }

    //task_05 build the square matrix according to a preassigned pattern: row_1 [1, 1, 1 ... 1, 1, 1],
    //row_2 [2, 2, 2 ... 2, 2, 0], row_n-1 [n-1, n-1, 0 ... 0, 0, 0], row_n [n, 0, 0 ... 0, 0, 0].
    //N is an even number.
    public static int[][] buildMatrixAccordingToPattern2(int orderOfMatrix) {
        int[][] matrix = null;
        boolean isOrderOfMatrixEvenNumber = orderOfMatrix % 2 == 0;
        if (orderOfMatrix > 1 && isOrderOfMatrixEvenNumber) {
            matrix = new int[orderOfMatrix][orderOfMatrix];
            for (int i = 0; i < orderOfMatrix; i++) {
                for (int j = 0; j < matrix[i].length - i; j++) {
                    matrix[i][j] = i + 1;
                }
            }
        }
        return matrix;
    }

    //task_06 build the square matrix according to a preassigned pattern: row_1 [1, 1, 1 ... 1, 1, 1],
    //row_2 [0, 1, 1 ... 1, 1, 0], row_3 [0, 0, 1 ... 1, 0, 0], penultimate_row [0, 1, 1 ... 1, 1, 0],
    //last_row [1, 1, 1 ... 1, 1, 1].
    //N is an even number.
    public static int[][] buildMatrixAccordingToPattern3(int orderOfMatrix) {
        int[][] matrix = null;
        boolean isOrderOfMatrixEvenNumber = orderOfMatrix % 2 == 0;
        if (orderOfMatrix > 1 && isOrderOfMatrixEvenNumber) {
            matrix = new int[orderOfMatrix][orderOfMatrix];
            final int rowBeforeMiddle = (matrix.length / 2) - 1;
            int numberOfZeros = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = numberOfZeros; j < (matrix[i].length - numberOfZeros); j++) {
                    matrix[i][j] = 1;
                }
                if (i < rowBeforeMiddle) {
                    numberOfZeros++;
                } else if (i > rowBeforeMiddle) {
                    numberOfZeros--;
                }
            }
        }
        return matrix;
    }

    //task_07 the method generate an square matrix according a formula
    public static double[][] generateSpecifiedMatrix(int orderOfMatrix) {
        double[][] matrix = null;
        if (orderOfMatrix > 1) {
            int counter = 0;
            matrix = new double[orderOfMatrix][orderOfMatrix];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = sin((Math.pow(i + 1, 2) - Math.pow(j + 1, 2)) / orderOfMatrix);
                    if (matrix[i][j] > 0.0) {
                        counter++;
                    }
                }
            }
            System.out.println("\nThe number of positive elements in the matrix is " + counter + ".");
        }
        return matrix;
    }

}
