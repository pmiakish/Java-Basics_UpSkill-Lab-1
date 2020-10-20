package com.epam.cycles;
import java.util.Scanner;

public class CyclesTaskA {

    public static void main(String[] args) {

    Scanner console = new Scanner(System.in);
    System.out.print("Enter the natural number A (non-negative integer greater than or equal to 1): ");
    int a = console.nextInt();

    if (a >= 1) {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        System.out.println("Total amount is " + sum);
    } else {
        System.out.println("The number must be greater than or equal to 1!");
    }

    }
}
