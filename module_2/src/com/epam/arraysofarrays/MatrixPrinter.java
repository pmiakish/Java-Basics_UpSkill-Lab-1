package com.epam.arraysofarrays;

public class MatrixPrinter {
    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.printf("%5d ", item);
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] matrix) {
        System.out.println();
        for (double[] row : matrix) {
            for (double item : row) {
                System.out.printf("%10f ", item);
            }
            System.out.println();
        }
    }
}
