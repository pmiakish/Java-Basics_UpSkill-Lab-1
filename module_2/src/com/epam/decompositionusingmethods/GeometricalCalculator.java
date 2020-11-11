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
        for (int i = 0; i < coordinates[0].length - 1; i++) {
            for (int j = i + 1; j < coordinates[0].length; j++) {
                distance = calculateDistanceBetweenTwoPoints(coordinates[0][i], coordinates[1][i], coordinates[0][j],
                        coordinates[1][j]);
                if (distance > maxDistance) {
                    numbersOfMostDistantPoints[0] = i;
                    numbersOfMostDistantPoints[1] = j;
                    maxDistance = distance;
                }
            }
        }
        return numbersOfMostDistantPoints;
    }

    private static double calculateDistanceBetweenTwoPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(Math.abs(x2 - x1), 2.0) + Math.pow(Math.abs(y2 - y1), 2.0));
    }

    public static double findAreaOfQuadrangleWithOneRightAngle(double xSideLength, double ySideLength, double
            zSideLength, double tSideLength) {
        double area = -1.0;
        double hypotenuse = Math.sqrt(Math.pow(xSideLength, 2.0) + Math.pow(ySideLength, 2.0));
        double firstPartAreaWithRightAngle = findRightTriangleArea(xSideLength, ySideLength);
        double secondPartAreaWithRightAngle = findTriangleAreaByLengthOfSides(hypotenuse, zSideLength, tSideLength);
        if (firstPartAreaWithRightAngle != -1.0 && secondPartAreaWithRightAngle != -1.0) {
            area = firstPartAreaWithRightAngle + secondPartAreaWithRightAngle;
        }
        return area;
    }


    private static double findRightTriangleArea(double firstLegLength, double secondLegLength) {
        double area = -1.0;
        if (firstLegLength > 0 && secondLegLength > 0) {
            area = firstLegLength * secondLegLength / 2;
        }
        return area;
    }

    private static double findTriangleAreaByLengthOfSides(double firstSideLength, double secondSideLength, double
            thirdSideLength) {
        double area = -1.0;
        if (firstSideLength > 0 && secondSideLength > 0 && thirdSideLength > 0) {
            double semiPerimeter = (firstSideLength + secondSideLength + thirdSideLength) / 2.0;
            area = Math.sqrt(semiPerimeter * (semiPerimeter - firstSideLength) * (semiPerimeter - secondSideLength) *
                    (semiPerimeter - thirdSideLength));
        }
        return area;
    }

}
