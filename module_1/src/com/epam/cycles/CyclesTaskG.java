package com.epam.cycles;
import java.util.Scanner;

public class CyclesTaskG {

    private static final int FIRST_DIGIT = 0;
    private static final int LAST_DIGIT = 9;

    public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    int firstNumber = Math.abs(console.nextInt());
    int[] firstNumberDigits = new int[String.valueOf(firstNumber).length()];
    System.out.print("Enter the second number: ");
    int secondNumber = Math.abs(console.nextInt());
    int[] secondNumberDigits = new int[String.valueOf(secondNumber).length()];

    for (int i = 0; i < firstNumberDigits.length; i++) {
        firstNumberDigits[i] = firstNumber % 10;
        firstNumber /= 10;
    }
    for (int i = 0; i < secondNumberDigits.length; i++) {
        secondNumberDigits[i] = secondNumber % 10;
        secondNumber /= 10;
    }

    System.out.print("The same digits are in the both numbers: ");
    for (int i = FIRST_DIGIT; i <= LAST_DIGIT; i++) {
        boolean findDigitFirstNumber = false;
        boolean findDigitSecondNumber = false;
        for (int j = 0; j < firstNumberDigits.length; j++) {
            if (firstNumberDigits[j] == i) {
                findDigitFirstNumber = true;
                break;
            }
        }
        if (findDigitFirstNumber) {
            for (int j = 0; j < secondNumberDigits.length; j++) {
                if (secondNumberDigits[j] == i) {
                    findDigitSecondNumber = true;
                    break;
                }
            }
        }
        if (findDigitFirstNumber && findDigitSecondNumber) {
            System.out.print(i + " ");
        }
    }
    }
}
