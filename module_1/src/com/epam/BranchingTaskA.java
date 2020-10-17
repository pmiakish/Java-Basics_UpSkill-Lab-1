package com.epam;
import java.util.Scanner;
import java.util.Locale;

public class BranchingTaskA {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("Enter the first angle value in degrees: ");
        double a = console.nextDouble();
        System.out.print ("Enter the second angle value in degrees: ");
        double b = console.nextDouble();
            if (a+b<180.0) {
                if (a == 90.0 || b == 90.0 || a+b == 90.0) System.out.println ("This is a right-angled triangle");
                else System.out.println ("This isn't a right-angled triangle");
            }
            else {
                System.out.println ("A triangle with defined angles doesn't exist!");
            }
    }
}