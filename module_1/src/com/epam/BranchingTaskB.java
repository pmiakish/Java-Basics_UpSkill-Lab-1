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
        System.out.print ("Enter the value 'c': ");
        double c = console.nextDouble();
        System.out.print ("Enter the value 'd': ");
        double d = console.nextDouble();
        System.out.println ("Expression value = " + Math.max(Math.min(a,b), Math.min(c,d)));
    }
}