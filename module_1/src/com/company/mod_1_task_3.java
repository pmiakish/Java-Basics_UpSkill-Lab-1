package com.company;
import java.util.Scanner;

public class mod_1_task_3 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double z;
        System.out.print ("Введите значение x: ");
        double x = console.nextDouble();
        System.out.print ("Введите значение y: ");
        double y = console.nextDouble();
        z = (Math.sin(x)+Math.cos(y)) / (Math.cos(x)+Math.sin(y)) * (Math.tan(x*y));
        System.out.println ("(sin(x)+cos(y)) / (cos(x)+sin(y)) * (tan(x*y))  = " + z);
    }
}
