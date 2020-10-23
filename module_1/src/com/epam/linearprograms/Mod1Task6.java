package com.epam.module1.linearprograms;
import java.util.Scanner;
import java.util.Locale;

public class Mod1Task6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println ("Enter the coordinates: ");
        System.out.print ("x value: ");
        double x = console.nextDouble();
        System.out.print ("y value: ");
        double y = console.nextDouble();
        System.out.println ((x<=4&&x>=-4&&y<=0&&y>=-3)||(x<=2&&x>=-2&&y<=4&&y>0));
    }
}