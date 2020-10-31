package com.epam.arrraysofarrays;

public class MatrixAnalyzer {

    private static final int NUMBER_OF_DIAGONALS = 2; // task_02

    // task_01
    public static StringBuilder defineOddColumnsIfFirstItemIsGreaterThanLast(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < matrix[0].length; j += 2) {
            if (matrix[0][j] > matrix[matrix.length - 1][j]) {
                result.append("\n");
                for (int[] row : matrix) {
                    result.append(row[j]).append(" ");
                }
            }
        }
        return result;
    }

    // task_02
    public static int[][] defineDiagonalNumbers(int[][] matrix) {
        int[][] diagonalNumbers = null;
        if (checkIfMatrixIsSquare(matrix)) {
            diagonalNumbers = new int[NUMBER_OF_DIAGONALS][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                diagonalNumbers[0][i] = matrix[i][i];
                diagonalNumbers[1][i] = matrix[i][matrix.length - 1 - i];
            }
        } else {
            System.out.println("\nThe generated matrix isn't square!");
        }
        return diagonalNumbers;
    }

    // task_02 for checking if the matrix is square
    private static boolean checkIfMatrixIsSquare(int[][] matrix) {
        boolean isSquareMatrix = true;
        for (int[] row : matrix) {
            if (row.length != matrix.length) {
                isSquareMatrix = false;
                break;
            }
        }
        return isSquareMatrix;
    }

    // task_03
    public static void printKRowAndPColumn(int[][] matrix, int row, int column) {
        if (row >= 0 && row < matrix.length && column >= 0 &&
                column < matrix[0].length) {
            System.out.println("\nThe row [" + row + "] is:");
            for (int item : matrix[row - 1]) {
                System.out.print(item + " ");
            }
            System.out.println("\n\nThe column [" + column + "] is:");
            for (int[] rowArray : matrix) {
                System.out.print(rowArray[column - 1] + " ");
            }
        } else {
            System.out.println("\nInvalid number of the row or column!");
        }
    }
}
