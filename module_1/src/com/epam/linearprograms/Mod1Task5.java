package com.epam.module1.linearprograms;
import java.util.Scanner;

public class Mod1Task5 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print ("Enter the natural number (non-negative integer greater than 0): ");
        int T = console.nextInt();
            if (T>=1) {
                System.out.printf ("Expression value = %02dh %02dm %02ds", T/3600, T%3600/60, T%60);
            }
            else {
                System.out.println ("an invalid number format!");
            }
    }
}
