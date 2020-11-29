package com.epam.simplestclassesandobjects;

import java.util.Arrays;
import java.util.Objects;

public class Student {

    private String studentName;
    private int groupNumber;
    private int[] grades;
    private final int NUMBER_OF_GRADES = 5;
    private final int MIN_CORRECT_GRADE = 0;
    private final int MAX_CORRECT_GRADE = 10;

    public Student(String studentName, int groupNumber, int[] grades) throws Exception {
        // studentName initialization
        if (studentName == null || studentName.compareTo("") == 0) {
            throw new Exception("Incorrect student name!");
        }
        this.studentName = studentName;
        // groupNumber initialization
        if (groupNumber < 0) {
            throw new Exception("The group mustn't have a negative number!");
        }
        this.groupNumber = groupNumber;
        // grades initialization
        boolean areCorrectGrades = true;
        for (int grade : grades) {
            if (!(grade >= MIN_CORRECT_GRADE && grade <= MAX_CORRECT_GRADE)) {
                areCorrectGrades = false;
                break;
            }
        }
        if (!areCorrectGrades) {
            throw new Exception("Incorrect values of the grades!");
        }
        this.grades = Arrays.copyOf(grades, NUMBER_OF_GRADES);
    }

    public Student() {
        studentName = "Unnamed";
        groupNumber = 0;
        grades = new int[] {0, 0, 0, 0, 0};
    }

    public void setStudentName(String studentName) throws Exception {
        if (studentName == null || studentName.compareTo("") == 0) {
            throw new Exception("Incorrect student name!");
        }
        this.studentName = studentName;
    }

    public void setGroupNumber(int groupNumber) throws Exception {
        if (groupNumber < 0) {
            throw new Exception("The group mustn't have a negative number!");
        }
        this.groupNumber = groupNumber;
    }

    public void setGrades(int[] grades) throws Exception {
        boolean areCorrectGrades = true;
        for (int grade : grades) {
            if (!(grade >= MIN_CORRECT_GRADE && grade <= MAX_CORRECT_GRADE)) {
                areCorrectGrades = false;
                break;
            }
        }
        if (grades.length != NUMBER_OF_GRADES || !areCorrectGrades) {
            throw new Exception("Incorrect values of the grades!");
        }
        this.grades = grades;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int[] getGrades() {
        return grades;
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
        return "Student [studentName: " + studentName + "; group: " + groupNumber + "; grades: " + Arrays.
                toString(grades) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return groupNumber == other.groupNumber &&
                studentName.equals(other.studentName) &&
                Arrays.equals(grades, other.grades);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(studentName, groupNumber);
        result = 31 * result + Arrays.hashCode(grades);
        return result;
    }
}
