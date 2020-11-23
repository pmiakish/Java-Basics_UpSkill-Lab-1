package com.epam.simplestclassesandobjects;

public class TaskLauncher {
    public static void main(String[] args) {

        // task 01
        System.out.println("--- TASK 01 ---");
        Test1 test = new Test1();
        test.setA(-1.0);
        test.setB(23.2);
        System.out.print("A-value is: ");
        test.printA();
        System.out.print("B-value is: ");
        test.printB();
        System.out.print("The sum of A and B is: " + test.sumAandB() + "\n");
        System.out.print("The max value of A and B is: " + test.findMaxValue() + "\n");

        // task 02
        System.out.println("\n--- TASK 02 ---");
        Test2 test21 = new Test2();
        test21.setA(-6.0);
        test21.setB(5.7);
        System.out.print("A-value of test21 is: " + test21.getA() + "\n");
        System.out.print("B-value of test21 is: " + test21.getB() + "\n");
        Test2 test22 = new Test2(3.0);
        System.out.print("A-value of test22 is: " + test22.getA() + "\n");
        System.out.print("B-value of test22 is: " + test22.getB() + "\n");

    }


}
