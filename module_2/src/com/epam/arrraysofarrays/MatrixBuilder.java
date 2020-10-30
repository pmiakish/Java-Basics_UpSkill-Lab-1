package com.epam.arrraysofarrays;

public class MatrixBuilder {

    // Random integer matrix with max, min values, predetermined numbers of rows and columns
    public static int[][] generateMatrix(int minValue, int maxValue, int numberOfRows, int numberOfColumns) {
        int[][] matrix = null;
        if (minValue < maxValue && numberOfRows > 1 && numberOfColumns > 1) {
            matrix = new int[numberOfRows][numberOfColumns];
            for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
                for (int currentColumn = 0; currentColumn < numberOfColumns; currentColumn++) {
                    matrix[currentRow][currentColumn] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
                }
            }
        }
        return matrix;
    }

    //task_04 build the square matrix according to a preassigned pattern: row_1 [1, 2, 3 ... n],
    //row_2 [n, n-1, n-2 ... 1], row_3 [1, 2, 3 ... n], row_n [n, n-1, n-2 ... 1]
    public static int[][] buildMatrixAccordingToPattern1(int orderOfMatrix) {
        int[][] matrix = null;
        if (orderOfMatrix > 1) {
            matrix = new int[orderOfMatrix][orderOfMatrix];
                for (int currentRow = 0; currentRow < orderOfMatrix; currentRow++) {
                    if (currentRow % 2 == 0) {
                        for (int currentColumn = 0; currentColumn < orderOfMatrix; currentColumn++) {
                            matrix[currentRow][currentColumn] = currentColumn + 1;
                        }
                    } else {
                        for (int currentColumn = 0; currentColumn < orderOfMatrix; currentColumn++) {
                            matrix[currentRow][currentColumn] = orderOfMatrix - currentColumn;
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
        if (orderOfMatrix > 1 && orderOfMatrix % 2 == 0) {
            matrix = new int[orderOfMatrix][orderOfMatrix];
            for (int currentRow = 0; currentRow < orderOfMatrix; currentRow++) {
                for (int currentColumn = 0; currentColumn < orderOfMatrix; currentColumn++) {
                    if (currentColumn < matrix[currentRow].length - currentRow) {
                        matrix[currentRow][currentColumn] = currentRow + 1;
                    } else {
                        matrix[currentRow][currentColumn] = 0;
                    }
                }
            }
        }
        return matrix;
    }


}
