package com.epam.aggregationandcomposition.service;

public class RandomNumberGenerator {

    public static int generate(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }

    public static byte generate(byte minValue, byte maxValue) {
        return (byte) (Math.random() * (maxValue - minValue + 1) + minValue);
    }

    public static float generate(float minValue, float rightBorder) {
        float result = (float) (Math.random() * (rightBorder - minValue) + minValue);
        return (float) Math.round(result * 10) / 10;
    }

}
