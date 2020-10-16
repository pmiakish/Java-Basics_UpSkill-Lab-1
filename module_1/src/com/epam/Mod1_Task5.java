package com.epam;
import java.util.Scanner;

public class Mod1_Task5 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print ("Enter the natural number (non-negative integer): ");
        int T = console.nextInt();
            if (T>=0) {
                System.out.printf ("Expression value = %02dh %02dm %02ds", T/3600, T%3600/60, T%60);
            }
            else {
                System.out.println ("an invalid number format!");
            }
    }
}
