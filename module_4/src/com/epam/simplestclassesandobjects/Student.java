package com.epam.simplestclassesandobjects;

import java.util.Arrays;

public class Student {

    private String studentName;
    private int groupNumber;
    private final int NUMBER_OF_GRADES = 5;
    private int[] grades;

    public Student(String studentName, int groupNumber, int[] grades) {
        this.studentName = studentName;
        this.grades = Arrays.copyOf(grades, NUMBER_OF_GRADES);
        this.groupNumber = groupNumber;
    }

    public boolean isExcellentStudent() {
        final int MIN_EXCELLENT_VALUE = 9;
        boolean isExcellentStudent = true;
        for (int grade : grades) {
            if (grade < MIN_EXCELLENT_VALUE) {
                isExcellentStudent = false;
                break;
            }
        }
        return isExcellentStudent;
    }

    @Override
    public String toString() {
        return studentName + ", group #" + groupNumber;
    }

}
