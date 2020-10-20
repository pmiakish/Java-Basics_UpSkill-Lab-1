package com.epam.cycles;
import java.util.Scanner;

public class CyclesTaskB {

    private static final double CONDITION_PARAMETER = 2.0;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Set the interval [a,b]:");
        System.out.print(" -- enter the value 'a': ");
        double a = console.nextDouble();
        System.out.print(" -- enter the value 'b': ");
        double b = console.nextDouble();
        System.out.print("Set the step value (h): ");
        double h = console.nextDouble();

        if (a < b && b - a >= h && h > 0) {
            System.out.println("Function values on the interval [" + a + ", " + b + "]:");
            for (double x = a; x <= b; x += h) {
                if (x <= CONDITION_PARAMETER) {
                    System.out.println("y = " + -x + " (x = " + x + ")");
                } else {
                    System.out.println("y = " + x + " (x = " + x + ")");
                }
            }
        } else {
            System.out.println("Incorrect interval [a,b] or step value (h)! Try again...");
        }
    }

}
