package com.epam;
import java.util.Scanner;
import java.util.Locale;

public class Mod1_Task3 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("Enter value x: ");
        double x = console.nextDouble();
        System.out.print ("Enter value y: ");
        double y = console.nextDouble();
            if ((Math.cos(x)+Math.sin(y))!=0) {
                System.out.println ("Expression value = " + ((Math.sin(x)+Math.cos(y)) / (Math.cos(x)+Math.sin(y)) * (Math.tan(x*y))));
            }
            else {
                System.out.println ("Can't divide by zero!");
            }
    }
}
