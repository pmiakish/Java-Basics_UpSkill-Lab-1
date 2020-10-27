package com.epam.onedimensionalarrays;
import java.util.Scanner;
import java.util.Locale;

public class Tasks {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Module 2. Algorithmization. One-dimensional arrays");
        System.out.print("Enter the task number: ");
        int taskNumber = console.nextInt();

        // Tasks
        switch (taskNumber) {
            case 1:
                SumOfNumbersDivisibleByK.getSum();
                break;
            case 2:
                ChangingSequenceElements.replaceElements();
                break;
            case 3:
                DoubleArrayChecking.checkElements();
                break;
            case 4:
                DoubleArrayMaxMinReplacing.repalceElements();
                break;
            case 5:
                IntArrayIndexValue.getValues();
                break;
            case 6:
                SumOfSequenceElements.addElementsWithPrimeIndexes();
                break;
            case 8:
                IntSequenceChanging.removeMinElements();
                break;
            case 9:
                IntArrayElementsFrequency.getMostFrequentElement();
                break;
            case 10:
                IntArrayElementsCompressing.compressArray();
                break;
            default:
                System.out.println("Task " + taskNumber + " not found");
                break;
        }
    }
}
