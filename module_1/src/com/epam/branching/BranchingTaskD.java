package com.epam.module1.branching;
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class BranchingTaskD {

    private static final int NUMBER_OF_SIDES = 3;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in).useLocale(Locale.US);

        System.out.println ("Enter the rectangle aperture's dimensions (A, B): ");
        System.out.print ("A value: ");
        double a = console.nextDouble();
        System.out.print ("B value: ");
        double b = console.nextDouble();
        System.out.println ("Enter the brick dimensions (x, y, z): ");
        double[] brickDimensions = new double[NUMBER_OF_SIDES];
        System.out.print ("x value: ");
        brickDimensions[0] = console.nextDouble();
        System.out.print ("y value: ");
        brickDimensions[1] = console.nextDouble();
        System.out.print ("z value: ");
        brickDimensions[2] = console.nextDouble();

        Arrays.sort(brickDimensions);

        if (Math.min(a,b) >= brickDimensions[0] && Math.max(a,b) >= brickDimensions[1]) {
            System.out.println ("The aperture matches");
        } else {
            System.out.println("The aperture doesn't match");
        }
    }
}