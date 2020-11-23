package com.epam.simplestclassesandobjects;

public class TaskLauncher {
    public static void main(String[] args) {
        // task 01
        Test1 test = new Test1();
        test.setA(-1.0);
        test.setB(23.2);
        System.out.print("A-value is: ");
        test.printA();
        System.out.print("B-value is: ");
        test.printB();
        System.out.print("The sum of A and B is: " + test.sumAandB() + "\n");
        System.out.print("The max value of A and B is: " + test.findMaxValue() + "\n");
    }


}
