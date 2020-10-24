package com.epam.branching;
import java.util.Scanner;
import java.util.Locale;

public class BranchingTaskC {
    public static void main(String[] args) {
        System.out.println ("Enter the coordinates of A, B, C points:");
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("A(x1) value: ");
        double x1 = console.nextDouble();
        System.out.print ("A(y1) value: ");
        double y1 = console.nextDouble();
        System.out.print ("B(x2) value: ");
        double x2 = console.nextDouble();
        System.out.print ("B(y2) value: ");
        double y2 = console.nextDouble();
        System.out.print ("C(x3) value: ");
        double x3 = console.nextDouble();
        System.out.print ("C(y3) value: ");
        double y3 = console.nextDouble();
            if ((x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1)) {
                System.out.println ("The points are on the same line");
            } else {
                System.out.println("The points aren't on the same line");
            }
    }
}