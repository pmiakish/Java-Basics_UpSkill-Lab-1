package com.epam.simplestclassesandobjects.entity;

import java.util.Arrays;

public class Triangle {

    private double[][] coordinates;
    // coordinates: x - double[][0], y - double[][1]

    private static final int NUMBER_OF_POINTS = 3;
    private static final int NUMBER_OF_COORDINATE_AXES = 2;

    public Triangle(double[][] coordinates) throws IllegalArgumentException {
        if (areCorrectCoordinates(coordinates)) {
            this.coordinates = new double[NUMBER_OF_POINTS][NUMBER_OF_COORDINATE_AXES];
            for (int i = 0; i < coordinates.length; i++) {
                System.arraycopy(coordinates[i], 0, this.coordinates[i], 0, coordinates[i].length);
            }
        } else {
            throw new IllegalArgumentException("Can't create an triangle! Wrong values of point coordinates.");
        }
    }

    public void setCoordinates(double[][] coordinates) throws IllegalArgumentException {
        if (!areCorrectCoordinates(coordinates)) {
            throw new IllegalArgumentException("Can't set triangle coordinates! Wrong values of point coordinates.");
        } else {
            for (int i = 0; i < coordinates.length; i++) {
                System.arraycopy(coordinates[i], 0, this.coordinates[i], 0, coordinates[i].length);
            }
        }
    }

    public double[][] getCoordinates() {
        return coordinates;
    }

    public double calculatePerimeter() {
        return calculateSegmentLength(coordinates[0], coordinates[1]) +
                calculateSegmentLength(coordinates[0], coordinates[2]) +
                calculateSegmentLength(coordinates[1], coordinates[2]);
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2.0;
        return Math.sqrt(p * (p - calculateSegmentLength(coordinates[0], coordinates[1])) *
                (p - calculateSegmentLength(coordinates[0], coordinates[2])) *
                (p - calculateSegmentLength(coordinates[1], coordinates[2])));
    }

    public double[] findCentroidLocation() {
        double x = 0.0;
        double y = 0.0;
        for (double[] coordinate : coordinates) {
            x += coordinate[0];
            y += coordinate[1];
        }
        return new double[] {(x / 3), (y / 3)};
    }

    private double calculateSegmentLength(double[] firstPointCoordinates, double[] secondPointCoordinates) {
        return Math.sqrt(Math.pow(secondPointCoordinates[0] - firstPointCoordinates[0], 2.0) +
                Math.pow(secondPointCoordinates[1] - firstPointCoordinates[1], 2.0));
    }

    private boolean areCorrectCoordinates(double[][] coordinates) {
        if (coordinates == null || coordinates.length != NUMBER_OF_POINTS) {
            return false;
        }
        for (int i = 0; i < coordinates.length - 1; i++) {
            if (coordinates[i].length != NUMBER_OF_COORDINATE_AXES) {
                return false;
            } else {
                for (int j = i + 1; j < coordinates.length; j++) {
                    if (Arrays.equals(coordinates[i], coordinates[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Triangle {coordinates: " + Arrays.deepToString(coordinates) + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Triangle other = (Triangle) obj;
        return Arrays.equals(coordinates, other.coordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }
}
