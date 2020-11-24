package com.epam.simplestclassesandobjects;

import com.epam.onedimensionalarrays.ArrayMaker;

public class TaskLauncher {

    // tasck 03
    private static final String[] NAMES_OF_STUDENTS = {"A.P. Ivanov", "B.P. Smirnov", "P.V. Miakish", "S.S. Pavlov",
            "N.P. Andreev", "V.L. Kizhniakov", "D.S. Radyuk", "K.N. Konon", "F.E. Dzerzhinsky", "I.M. Leonenko"};
    private static final int NUMBER_OF_STUDENTS_WITH_RANDOM_GRADES = 8;
    private static final int MIN_GROUP_NUMBER = 1;
    private static final int MAX_GROUP_NUMBER = 30;
    private static final int MIN_GRADE = 0;
    private static final int MIN_EXCELLENT_GRADE = 9;
    private static final int MAX_GRADE = 10;
    private static final int NUMBER_OF_GRADES = 5;
    private static final int NUMBER_OFSTUDENTS = 10;

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

        // task 03
        System.out.println("\n--- TASK 03 ---");
        Student[] students = new Student[NUMBER_OFSTUDENTS];
        // students with random grades
        for (int i = 0; i < NUMBER_OF_STUDENTS_WITH_RANDOM_GRADES; i++) {
            int randomGroupNumber = (int) (Math.random() * (MAX_GROUP_NUMBER - MIN_GROUP_NUMBER + 1) +
                    MIN_GROUP_NUMBER);
            int[] randomGrades = ArrayMaker.generateArray(MIN_GRADE, MAX_GRADE, NUMBER_OF_GRADES);
            students[i] = new Student(NAMES_OF_STUDENTS[i], randomGroupNumber, randomGrades);
        }
        // students with excellent grades
        for (int i = NUMBER_OF_STUDENTS_WITH_RANDOM_GRADES; i < students.length; i++) {
            int randomGroupNumber = (int) (Math.random() * (MAX_GROUP_NUMBER - MIN_GROUP_NUMBER + 1) +
                    MIN_GROUP_NUMBER);
            int[] excellentGrades = ArrayMaker.generateArray(MIN_EXCELLENT_GRADE, MAX_GRADE, NUMBER_OF_GRADES);
            students[i] = new Student(NAMES_OF_STUDENTS[i], randomGroupNumber, excellentGrades);
        }
        // searching for excellent students
        System.out.println("Excellent students:");
        for (Student student : students) {
            if (student.checkIfItIsExcellentStudent()) {
                System.out.println(student.getName() + ", group #" + student.getGroupNumber());
            }
        }

    }


}
