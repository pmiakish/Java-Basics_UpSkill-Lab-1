package com.epam.branching;
import java.util.Scanner;
import java.util.Locale;

public class BranchingTaskE {

    private static final double  CONDITION_PARAMETER = 3.0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("Enter the value 'x': ");
        double x = console.nextDouble();

            if (x <= CONDITION_PARAMETER) {
                System.out.println ("F(x) = " + (Math.pow(x,2) - 3.0 * x + 9.0));
            } else {
                System.out.println ("F(x) = " + (1.0 / (Math.pow(x,3) + 6)));
            }
    }
}