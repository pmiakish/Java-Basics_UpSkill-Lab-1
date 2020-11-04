package com.epam.arrraysofarrays;

public class MagicSquare {

    private static final int MIN_POSSIBLE_ORDER = 3;

    public static int[][] buildSquareWithOddOrder(int orderOfMatrix) {
        int[][] magicSquare = null;
        final boolean isOrderOfMatrixOddNumber = orderOfMatrix % 2 != 0;
        if (orderOfMatrix >= MIN_POSSIBLE_ORDER && isOrderOfMatrixOddNumber) {
            magicSquare = new int[orderOfMatrix][orderOfMatrix];
            final int maxValue = (int) Math.pow(orderOfMatrix, 2);
            final int lastIndex = orderOfMatrix - 1;
            int i = 0;
            int j = orderOfMatrix / 2; // the middle column
            int filler = 1; // the start value
            while (filler <= maxValue) {
                if (i < 0 && j <= lastIndex) {
                    i = lastIndex;
                } else if (i >= 0 && j > lastIndex) {
                    j = 0;
                } else if ( (i < 0 && j > lastIndex) || (magicSquare[i][j] != 0) ) {
                    i += 2;
                    j--;
                }
                magicSquare[i][j] = filler;
                filler++;
                i--;
                j++;
            }
        }
        return magicSquare;
    }







}
