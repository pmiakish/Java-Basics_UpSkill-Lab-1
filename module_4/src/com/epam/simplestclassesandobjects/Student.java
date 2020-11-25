package com.epam.simplestclassesandobjects;

public class Student {

    private String studentName;
    private int groupNumber;
    private final int NUMBER_OF_GRADES = 5;
    private int[] grades = new int[NUMBER_OF_GRADES];

    public Student(String studentName, int groupNumber, int[] grades) {
        this.studentName = studentName;
        for (int i = 0; i < this.grades.length && i < grades.length; i++) {
            this.grades[i] = grades[i];
            this.groupNumber = groupNumber;
        }
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
