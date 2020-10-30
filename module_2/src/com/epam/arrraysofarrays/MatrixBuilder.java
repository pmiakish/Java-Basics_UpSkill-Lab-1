package com.epam.arrraysofarrays;

public class MatrixBuilder {
    // Random integer matrix with max, min values, predetermined numbers of rows and columns
    public static int[][] generateMatrix(int minValue, int maxValue, int numberOfRows, int numberOfColumns) {
        int[][] matrix = new int[numberOfRows][numberOfColumns];
        for (int currentRow  = 0; currentRow < numberOfRows; currentRow++) {
            for (int currentColumn = 0; currentColumn < numberOfColumns; currentColumn++) {
                matrix[currentRow][currentColumn] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
            }
        }
        return matrix;
    }
}
