package com.epam;
import java.util.Scanner;
import java.util.Locale;

public class BranchingTaskB {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("Enter the value 'a': ");
        double a = console.nextDouble();
        System.out.print ("Enter the value 'b': ");
        double b = console.nextDouble();
        double minAB;
            if (a<=b) {
                minAB = a;
            }
            else {
                minAB = b;
            }
        System.out.print ("Enter the value 'c': ");
        double c = console.nextDouble();
        System.out.print ("Enter the value 'd': ");
        double d = console.nextDouble();
        double minCD;
            if (c<=d) {
                minCD = c;
            }
            else {
                minCD = d;
            }

            if (minAB>=minCD) {
                System.out.println ("Expression value = " + minAB);
            }
            else {
                System.out.println ("Expression value = " + minCD);
            }
    }
}