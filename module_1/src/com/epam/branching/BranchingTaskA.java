package com.epam.module1.branching;
import java.util.Scanner;
import java.util.Locale;

public class BranchingTaskA {

    private static final double SUM_OF_ANGLES = 180.0;
    private static final double RIGHT_ANGLE = 90.0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("Enter the first angle value in degrees: ");
        double a = console.nextDouble();
        System.out.print ("Enter the second angle value in degrees: ");
        double b = console.nextDouble();
        
        if (a + b < SUM_OF_ANGLES) {
            if (a == RIGHT_ANGLE || b == RIGHT_ANGLE || a+b == RIGHT_ANGLE) {
                System.out.println ("This is a right-angled triangle");
            } else {
                System.out.println("This isn't a right-angled triangle");
            }
        } else {
            System.out.println ("A triangle with defined angles doesn't exist!");
        }
    }
}
