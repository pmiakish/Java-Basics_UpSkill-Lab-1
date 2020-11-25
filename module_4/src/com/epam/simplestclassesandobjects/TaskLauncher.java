package com.epam.simplestclassesandobjects;

import com.epam.onedimensionalarrays.ArrayMaker;

public class TaskLauncher {

    // tasks 01, 02
    private static final double A_VALUE = -1.0;
    private static final double B_VALUE = 23.2;

    // task 03
    private static final int NUMBER_OF_STUDENTS = 10;
    private static final int NUMBER_OF_EXCELLENT_STUDENTS = 3;

    public static void main(String[] args) {

        // task 01
        System.out.println("--- TASK 01 ---");
        Test1 test1 = new Test1();
        test1.setA(A_VALUE);
        test1.setB(B_VALUE);
        System.out.println(test1);
        System.out.print("The sum of variables is: " + test1.sumOfVariables() + "\n");
        System.out.print("The max value of variables is: " + test1.findMaxValueOfVariables() + "\n");

        // task 02
        System.out.println("\n--- TASK 02 ---");
        Test2 test21 = new Test2();
        test21.setA(A_VALUE);
        test21.setB(B_VALUE);
        System.out.print("A-value of test21 is: " + test21.getA() + "\n");
        System.out.print("B-value of test21 is: " + test21.getB() + "\n");
        Test2 test22 = new Test2(A_VALUE);
        System.out.print("A-value of test22 is: " + test22.getA() + "\n");
        System.out.print("B-value of test22 is: " + test22.getB() + "\n");

        // task 03
        System.out.println("\n--- TASK 03 ---");
        System.out.println("Excellent students:");
        Student[] students = StudentGenerator.generateStudentArray(NUMBER_OF_STUDENTS, NUMBER_OF_EXCELLENT_STUDENTS);
        for (Student student : students) {
            if (student.isExcellentStudent()) {
                System.out.println(student);
            }
        }

    }


}
