package com.epam.onedimensionalarrays;

public class ArrayReader {
    public static void printInt(int[] arrayInt) {
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println("");
    }

    public static void printDouble (double[] arrayDouble) {
        for (int i = 0; i < arrayDouble.length; i++) {
            System.out.print(arrayDouble[i] + " ");
        }
        System.out.println("");
    }
}
