package com.epam;
import java.util.Scanner;
import java.util.Locale;

public class BranchingTaskE {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("Enter the value 'x': ");
        double x = console.nextDouble();
            if (x<=3.0) {
                System.out.println ("Expression value = " + (Math.pow(x,2)-3.0*x+9.0));
            }
        else {
                System.out.println ("F(x) = " + (1.0 / (Math.pow(x,3)+6)));
            }
    }
}