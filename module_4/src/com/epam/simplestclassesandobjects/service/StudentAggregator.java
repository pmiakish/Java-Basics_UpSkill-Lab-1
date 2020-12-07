package com.epam.simplestclassesandobjects.service;

import com.epam.onedimensionalarrays.ArrayMaker;
import com.epam.simplestclassesandobjects.entity.Student;

public class StudentAggregator {

    private static final String[] NAMES_OF_STUDENTS = {"A.P. Ivanov", "B.P. Smirnov", "P.V. Miakish", "S.S. Pavlov",
            "N.P. Andreev", "V.L. Kizhniakov", "D.S. Radyuk", "K.N. Konon", "F.E. Dzerzhinsky", "I.M. Leonenko",
            "Z.P. Kolobanov", "L.L. Ovcharenkov", "T.M. Shuster", "U.O. Grichyany", "R.R. Amoev", "S.P. Ambros",
            "L.N. Sinkevich", "A.P. Zhurak", "O.I. Bazyl", "A.A. Kondratovich", "I.V. Sevko", "G.P. Zunevich"};
    private static final int MIN_GROUP_NUMBER = 1;
    private static final int MAX_GROUP_NUMBER = 30;
    private static final int MIN_GRADE = 0;
    private static final int MIN_EXCELLENT_GRADE = 9;
    private static final int MAX_GRADE = 10;
    private static final int NUMBER_OF_GRADES = 5;

    public static Student[] generateStudentArray(int numberOfStudents, int numberOfExcellentStudents) {
        Student[] students = (numberOfStudents > 0) ? new Student[numberOfStudents] : null;
        // students with random grades
        if (numberOfStudents > numberOfExcellentStudents && numberOfExcellentStudents >= 0) {
            final int numberOfStudentsWithRandomGrades = numberOfStudents - numberOfExcellentStudents;
            for (int i = 0; i < numberOfStudentsWithRandomGrades; i++) {
                int randomGroupNumber = generateRandomNumber(MIN_GROUP_NUMBER, MAX_GROUP_NUMBER);
                int[] randomGrades = ArrayMaker.generateArray(MIN_GRADE, MAX_GRADE, NUMBER_OF_GRADES);
                try {
                    students[i] = new Student(NAMES_OF_STUDENTS[generateRandomNumber(0, NAMES_OF_STUDENTS.length - 1)],
                            randomGroupNumber, randomGrades);
                } catch (IllegalArgumentException ex) {
                    students[i] = new Student();
                    System.out.println(ex.getMessage());
                }
            }
            // students with excellent grades
            for (int i = numberOfStudentsWithRandomGrades; i < numberOfStudents; i++) {
                int randomGroupNumber = generateRandomNumber(MIN_GROUP_NUMBER, MAX_GROUP_NUMBER);
                int[] excellentGrades = ArrayMaker.generateArray(MIN_EXCELLENT_GRADE, MAX_GRADE, NUMBER_OF_GRADES);
                try {
                    students[i] = new Student(NAMES_OF_STUDENTS[generateRandomNumber(0, NAMES_OF_STUDENTS.length - 1)],
                            randomGroupNumber, excellentGrades);
                } catch (IllegalArgumentException ex) {
                    students[i] = new Student();
                    System.out.println(ex.getMessage());
                }
            }
        }
        return students;
    }

    private static int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }


}
