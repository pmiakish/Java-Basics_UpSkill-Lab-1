package com.epam.decompositionusingmethods;

public class GeometricalCalculator {
    public static double findRegularHexagonArea(double sideLength) {
        double area = -1.0;
        if (sideLength > 0) {
            area = 6 * (Math.pow(sideLength, 2.0) * Math.sin(Math.toRadians(60.0)) / 2);
        }
        return area;
    }

}
