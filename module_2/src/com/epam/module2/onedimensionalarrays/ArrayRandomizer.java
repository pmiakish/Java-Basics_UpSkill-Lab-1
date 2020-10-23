package com.epam.module2.onedimensionalarrays;

public class ArrayRandomizer {

    // Integer array
    public static int[] getIntArray (int minValue, int maxValue, int amounOfNumbers) {
        int[] arrayInt = new int[amounOfNumbers];
        for (int i  = 0; i < arrayInt.length; i++) {
            arrayInt[i] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        }
        return arrayInt;
    }
}
