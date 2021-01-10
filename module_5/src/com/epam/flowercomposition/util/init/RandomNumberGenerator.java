package com.epam.flowercomposition.util.init;

public class RandomNumberGenerator {
    public static int generate(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }
}
