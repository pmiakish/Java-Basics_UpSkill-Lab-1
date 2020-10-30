package com.epam.arrraysofarrays;

/**
 * Task 01: the method printOddColumnsIfFirstNumberIsGreaterThanLastNumber prints only odd columns
 * of the matrix whose first element is greater than the last element
 */

public class MatrixSelectivePrinter {

    //task_01
    public static void printOddColumnsIfFirstNumberIsGreaterThanLastNumber(int[][] generatedMatrix) {
        int[] indicators = createIndicatorsToPrintArray(generatedMatrix);
        System.out.println();
        for (int currentRow = 0; currentRow < generatedMatrix.length; currentRow++) {
            for (int currentColumn = 0; currentColumn < generatedMatrix[currentRow].length; currentColumn++) {
                if (indicators[currentColumn] == 1) {
                    System.out.printf("%5d ", generatedMatrix[currentRow][currentColumn]);
                }
            }
            System.out.println();
        }
    }

    //task_01 for printing only odd columns if their first item is greater than last
    private static int[] createIndicatorsToPrintArray(int[][] generatedMatrix) {
        int[] indicators = new int[generatedMatrix[0].length];
        for (int currentColumn = 0; currentColumn < generatedMatrix[0].length; currentColumn++) {
            if ((currentColumn + 1) % 2 != 0) {
                if (generatedMatrix[0][currentColumn] > generatedMatrix[generatedMatrix.length - 1][currentColumn]) {
                    indicators[currentColumn] = 1;
                } else {
                    indicators[currentColumn] = 0;
                }
            } else {
                indicators[currentColumn] = 0;
            }
        }
        return indicators;
    }

    //task_02
    public static void printDiagonalNumbers(int[][] generatedSquareMatrix) {
        if (checkIfMatrixIsSquare(generatedSquareMatrix)) {
            System.out.print("\nThe numbers located on the diagonals of the matrix are ");
            for (int currentRow = 0; currentRow < generatedSquareMatrix.length; currentRow++) {
                for (int currentColumn = 0; currentColumn <
                        generatedSquareMatrix[currentRow].length; currentColumn++) {
                    if (currentColumn == currentRow || currentRow ==
                            generatedSquareMatrix[currentRow].length - 1 - currentColumn) {
                        System.out.print(generatedSquareMatrix[currentRow][currentColumn] + " ");
                    }
                }
            }
        } else {
            System.out.println("\nThe generated matrix isn't square!");
        }
    }

    //task_02 for checking if the matrix is square
    private static boolean checkIfMatrixIsSquare(int[][] generatedMatrix) {
        boolean isSquareMatrix = true;
        for (int[] row : generatedMatrix) {
            if (row.length != generatedMatrix.length) {
                isSquareMatrix = false;
                break;
            }
        }
        return isSquareMatrix;
    }
}
