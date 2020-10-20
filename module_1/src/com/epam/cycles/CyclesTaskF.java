package com.epam.cycles;
import java.util.Scanner;

public class CyclesTaskF {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Set the interval [m,n] including natural numbers: ");
        System.out.print("-- enter the value 'm': ");
        int m = console.nextInt();
        System.out.print("-- enter the value 'n': ");
        int n = console.nextInt();

        if (m > 0 && m < n) {
            System.out.println("\nDivisors of numbers (excluding 1 and the same number):");

            for (int currentNumber = m; currentNumber <= n; currentNumber++) {
                boolean isCompositeNaturalNumber = false;
                System.out.print("\nThe number " + currentNumber + " -> ");
                int divisor = 2;
                while (divisor < currentNumber / 2) {
                    if (currentNumber % divisor == 0) {
                        System.out.print(divisor + " ");
                        isCompositeNaturalNumber = true;
                    }
                    divisor++;
                }
                if (!isCompositeNaturalNumber) {
                    System.out.print("prime number");
                }
            }

        } else {
            System.out.println("\nIncorrect interval! Try again...");
        }
    }

}
