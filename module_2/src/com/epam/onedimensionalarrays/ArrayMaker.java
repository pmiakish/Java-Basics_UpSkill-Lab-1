package com.epam.onedimensionalarrays;

public class ArrayMaker {

    // Random integer array with max i min values
    public static int[] getIntArray (int minValue, int maxValue, int amounOfNumbers) {
        int[] arrayInt = new int[amounOfNumbers];
        for (int i  = 0; i < arrayInt.length; i++) {
            arrayInt[i] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        }
        return arrayInt;
    }

    // Random double sequence
    public static double[] getDoubleSequence (int amounOfNumbers) {
        double randomeDivend = Math.random() - Math.random();
        double randomeDivendFactor = Math.random() + Math.random();
        while (randomeDivend == 0 || randomeDivendFactor == 0) {
            randomeDivend += Math.random() - Math.random();
            randomeDivendFactor += Math.random() + Math.random();
        }
        double randomeDivisor = Math.random() - Math.random();
        double randomeDivisorFactor = Math.random() + Math.random();
        while (randomeDivisor == 0 || randomeDivisorFactor == 0) {
            randomeDivisor += Math.random() - Math.random();
            randomeDivisorFactor += Math.random() + Math.random();
        }

        double[] arrayDouble = new double[amounOfNumbers];
        for (int i  = 0; i < arrayDouble.length; i++) {
            randomeDivend *= randomeDivendFactor;
            randomeDivisor *= randomeDivisorFactor;
            arrayDouble[i] = randomeDivend / randomeDivisor;
        }
        return arrayDouble;
    }

}
