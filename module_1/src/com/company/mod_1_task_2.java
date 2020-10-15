package com.company;
import java.util.Scanner;

public class mod_1_task_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double z;
        System.out.print ("Введите значение a: ");
        double a = console.nextDouble();
        System.out.print ("Введите значение b: ");
        double b = console.nextDouble();
        System.out.print ("Введите значение c: ");
        double c = console.nextDouble();
        z = (b+Math.sqrt(Math.pow(b, 2.0)+4*a*c))/(2*a)-(Math.pow(a, 3.0)*c)+(Math.pow(b, -2.0));
        System.out.println ("(b + \u221A(b\u00B2+4ac) ) / (2a) - (a\u00B3c) + (b\u207B\u00B2)  = " + z);
    }
}
