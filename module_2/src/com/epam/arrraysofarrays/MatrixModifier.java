package com.epam.arrraysofarrays;

import java.util.Arrays;

public class MatrixModifier {

    // task_08
    public static boolean replaceColumns(int[][] matrix, int firstColumn, int secondColumn) {
        boolean isModified = false;
        if (firstColumn >= 0 && firstColumn < matrix[0].length && secondColumn >= 0 && secondColumn < matrix[0].length
                && firstColumn != secondColumn) {
            int temp;
            for (int i = 0; i < matrix.length; i++) {
                temp = matrix[i][firstColumn];
                matrix[i][firstColumn] = matrix[i][secondColumn];
                matrix[i][secondColumn] = temp;
            }
            isModified = true;
        }
        return isModified;
    }

    // task_12
    public static void sortRows(int[][] matrix, boolean descendingOrder) {
        for (int[] row : matrix) {
            Arrays.sort(row);
        }
        if (descendingOrder) {
            for (int i = 0; i < matrix.length; i++) {
                int lastItemIndex = matrix[i].length - 1;
                int middleOfRow = matrix[i].length / 2;
                int tempItem;
                for (int j = 0; j < middleOfRow; j++) {
                    tempItem = matrix[i][j];
                    matrix[i][j] = matrix[i][lastItemIndex - j];
                    matrix[i][lastItemIndex - j] = tempItem;
                }
            }
        }
    }

    // task_13
    public static void sortColumns(int[][] matrix, boolean descendingOrder) {
        int[] tempColumn = new int[matrix.length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                tempColumn[i] = matrix[i][j];
            }
            Arrays.sort(tempColumn);
            if (descendingOrder) {
                int lastItemIndex = tempColumn.length - 1;
                int middleOfColumn = tempColumn.length / 2;
                int tempItem;
                for (int z = 0; z < middleOfColumn; z++) {
                    tempItem = tempColumn[z];
                    tempColumn[z] = tempColumn[lastItemIndex - z];
                    tempColumn[lastItemIndex - z] = tempItem;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = tempColumn[i];
            }
        }
    }

    // task_15
    public static boolean replaceOddItems(int[][] matrix) {
        boolean areOddNumbers = false;
        boolean isOddNumber;
        int replacementValue = defineMaxItem(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                isOddNumber = matrix[i][j] % 2 != 0;
                if (isOddNumber) {
                    matrix[i][j] = replacementValue;
                    areOddNumbers = true;
                }
            }
        }
        return areOddNumbers;
    }

    // task_15
    private static int defineMaxItem(int[][] matrix) {
        int maxItem = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int item : row) {
                if (item > maxItem) {
                    maxItem = item;
                }
            }
        }
        return maxItem;
    }


}
