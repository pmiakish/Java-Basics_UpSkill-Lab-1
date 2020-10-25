package com.epam.onedimensionalarrays;

public class ArrayMaker {

    // Random integer array with max and min values
    public static int[] getIntArray(int minValue, int maxValue, int amountOfNumbers) {
        int[] arrayInt = new int[amountOfNumbers];
        for (int i  = 0; i < arrayInt.length; i++) {
            arrayInt[i] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        }
        return arrayInt;
    }

    // Random double array with max and min values
    public static double[] getDoubleArray(double minValue, double maxValue, int amountOfNumbers) {
        double[] arrayDouble = new double[amountOfNumbers];
        for (int i  = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = Math.random() * (maxValue - minValue) + minValue;
        }
        return arrayDouble;
    }

    // integer sequence
    public static int[] getIntSequence(int amountOfNumbers) {
        int a = (int) ((Math.random() - Math.random()) * (Math.random() - Math.random()) * 10.0);
        int b = (int) ((Math.random() - Math.random()) * 10.0);
        int c = (int) ((Math.random() - Math.random()) * 10.0);

        while (b == 0 || c == 0) {
            b += (int) ((Math.random() - Math.random()) * 10.0);
            c += (int) ((Math.random() - Math.random()) * 10.0);
        }

        int[] arrayInt = new int[amountOfNumbers];
        arrayInt[0] = a + (b * c) - (b + c);
        System.out.println("a" + a + " b" + b + " c" + c);//trace
        for (int i  = 1; i < arrayInt.length; i++) {
            arrayInt[i] = arrayInt[i-1] + (a + (b * c) - (b + c));
        }
        return arrayInt;
    }

    // double sequence
    public static double[] getDoubleSequence(int amountOfNumbers) {
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

        double[] arrayDouble = new double[amountOfNumbers];
        for (int i  = 0; i < arrayDouble.length; i++) {
            randomeDivend *= randomeDivendFactor;
            randomeDivisor *= randomeDivisorFactor;
            arrayDouble[i] = randomeDivend / randomeDivisor;
        }
        return arrayDouble;
    }

}
