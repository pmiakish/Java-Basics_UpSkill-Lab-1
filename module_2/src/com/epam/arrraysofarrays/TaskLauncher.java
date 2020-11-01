package com.epam.arrraysofarrays;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TaskLauncher {

    private static final int MIN_VALUE_OF_MATRIX = -25;
    private static final int MIN_NON_NEGATIVE_VALUE_OF_MATRIX = 0;
    private static final int MAX_VALUE_OF_MATRIX = 25;
    private static final int AMOUNT_OF_ROWS_OF_MATRIX = 5;
    private static final int AMOUNT_OF_COLUMNS_OF_MATRIX = 8;
    private static final int AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX = 7;
    private static final int ROW_FOR_PRINT_NUMBER = 3;
    private static final int COLUMN_FOR_PRINT_NUMBER = 2;
    private static final int ORDER_OF_SQUARE_MATRIX = 8;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Module 2. Algorithmization. Arrays of arrays");
        System.out.print("Enter the task number: ");
        int taskNumber = console.nextInt();

        // Tasks
        switch (taskNumber) {
            case 1:
                int[][] generatedMatrixForFirstTask = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX,
                        MAX_VALUE_OF_MATRIX, AMOUNT_OF_ROWS_OF_MATRIX, AMOUNT_OF_COLUMNS_OF_MATRIX);
                if (generatedMatrixForFirstTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForFirstTask);
                    StringBuilder result = MatrixAnalyzer.
                            defineOddColumnsIfFirstItemIsGreaterThanLast(generatedMatrixForFirstTask);
                    if (result.length() != 0) {
                        System.out.println("\nThe odd columns of the matrix which have the first number greater than " +
                                "the last number:\n" + result);
                    } else {
                        System.out.println("\nColumns with specified parameters not found!");
                    }
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 2:
                int[][] generatedMatrixForSecondTask = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX,
                        MAX_VALUE_OF_MATRIX, AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX,
                        AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX);
                if (generatedMatrixForSecondTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForSecondTask);
                    int[][] diagonalNumbers = MatrixAnalyzer.defineDiagonalNumbers(generatedMatrixForSecondTask);
                    if (diagonalNumbers != null) {
                        System.out.print("\nThe numbers located on the first diagonal of the matrix are " + Arrays.
                                toString(diagonalNumbers[0]));
                        System.out.print("\nThe numbers located on the second diagonal of the matrix are " + Arrays.
                                toString(diagonalNumbers[1]));
                    } else {
                        System.out.println("\nDiagonal numbers wasn't defined.");
                    }
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 3:
                int[][] generatedMatrixForThirdTask = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX,
                        MAX_VALUE_OF_MATRIX,AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX,
                        AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX);
                if (generatedMatrixForThirdTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForThirdTask);
                    StringBuilder result = MatrixAnalyzer.defineKRowAndPColumn(generatedMatrixForThirdTask,
                            ROW_FOR_PRINT_NUMBER, COLUMN_FOR_PRINT_NUMBER);
                    if (result.length() != 0) {
                        System.out.println(result);
                    } else {
                        System.out.println("\nCheck numbers of the row and column!");
                    }
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 4:
                int[][] generatedMatrixForFourthTask =
                        MatrixBuilder.buildMatrixAccordingToPattern1(ORDER_OF_SQUARE_MATRIX);
                if (generatedMatrixForFourthTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForFourthTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 5:
                int[][] generatedMatrixForFifthTask = MatrixBuilder.
                                buildMatrixAccordingToPattern2(ORDER_OF_SQUARE_MATRIX);
                if (generatedMatrixForFifthTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForFifthTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 6:
                int[][] generatedMatrixForSixthTask = MatrixBuilder.
                                buildMatrixAccordingToPattern3(ORDER_OF_SQUARE_MATRIX);
                if (generatedMatrixForSixthTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForSixthTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 7:
                double[][] generatedMatrixForSeventhTask = MatrixBuilder.
                        generateSpecifiedMatrix(ORDER_OF_SQUARE_MATRIX);
                if (generatedMatrixForSeventhTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForSeventhTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 8:
                int[][] generatedMatrixForEighthTask = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX,
                        MAX_VALUE_OF_MATRIX,AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX,
                        AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX);
                if (generatedMatrixForEighthTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForEighthTask);
                    System.out.print("\nEnter the first column number for replacing: ");
                    int firstColumn = console.nextInt();
                    System.out.print("Enter the second column number for replacing: ");
                    int secondColumn = console.nextInt();
                    boolean isModified = MatrixModifier.replaceColumns(generatedMatrixForEighthTask, firstColumn,
                            secondColumn);
                    if (isModified) {
                        System.out.println("\nThe modified matrix:");
                        MatrixPrinter.printMatrix(generatedMatrixForEighthTask);
                    } else {
                        System.out.println("\nCheck numbers of the columns!");
                    }
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 9:
                int[][] generatedMatrixForNinthTask = MatrixBuilder.
                        generateNonNegativeMatrix(MIN_NON_NEGATIVE_VALUE_OF_MATRIX, MAX_VALUE_OF_MATRIX,
                        AMOUNT_OF_ROWS_OF_MATRIX, AMOUNT_OF_COLUMNS_OF_MATRIX);
                if (generatedMatrixForNinthTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixPrinter.printMatrix(generatedMatrixForNinthTask);
                    int[] sum = MatrixAnalyzer.defineSumOfColumnsItems(generatedMatrixForNinthTask);
                    System.out.println("\nThe sums of the items of each column are: " + Arrays.toString(sum));
                    int maxSumColumn = MatrixAnalyzer.defineMaxSumItem(sum);
                    if (maxSumColumn != -1) {
                        System.out.println("\nThe max sum of its items has the column #" + (maxSumColumn + 1));
                    } else {
                        System.out.println("\nMore than one value of the maximum sum of column elements was found.");
                    }
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            default:
                System.out.println("Task " + taskNumber + " not found");
                break;
        }
    }
}
