package com.epam.decompositionusingmethods;

public class GeometricalCalculator {

    private static final int NUMBER_OF_POINTS = 2;

    public static double findRegularHexagonArea(double sideLength) {
        double area = -1.0;
        if (sideLength > 0) {
            area = 6 * (Math.pow(sideLength, 2.0) * Math.sin(Math.toRadians(60.0)) / 2);
        }
        return area;
    }

    public static int[] findMostDistantPoints(double[][] coordinates) {
        int[] numbersOfMostDistantPoints = new int[NUMBER_OF_POINTS];
        double maxDistance = 0.0;
        double distance;
        searching : for (int i = 0; i < coordinates[0].length - 1; i++) {
            for (int j = i + 1; j < coordinates[0].length; j++) {
                distance = calculateDistanceBetweenTwoPoints(coordinates[0][i], coordinates[1][i], coordinates[0][j],
                        coordinates[1][j]);
                if (distance > maxDistance) {
                    numbersOfMostDistantPoints[0] = i;
                    numbersOfMostDistantPoints[1] = j;
                    maxDistance = distance;
                } else if (distance == -1.0) {
                    numbersOfMostDistantPoints = null;
                    break searching;
                }
            }
        }
        return numbersOfMostDistantPoints;
    }


    private static double calculateDistanceBetweenTwoPoints(double x1, double y1, double x2, double y2) {
        double distance = -1.0;
        if (!(x1 == x2 && y1 == y2)) {
            distance = Math.sqrt(Math.pow(Math.abs(x2 - x1), 2.0) + Math.pow(Math.abs(y2 - y1), 2.0));
        }
        return distance;
    }


}
