package com.epam.simplestclassesandobjects;

public class Student {

    private String surnameAndInitials;
    private int groupNumber;
    private int[] academicPerformance = new int[5];

    public Student(String studentName, int groupNumberValue, int[] grades) {
        surnameAndInitials = studentName;
        for (int i = 0; i < grades.length && i < academicPerformance.length; i++) {
            academicPerformance[i] = grades[i];
        }
        if (groupNumberValue > 0) {
            groupNumber = groupNumberValue;
        }
    }

    public String getName() {
        return surnameAndInitials;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public boolean checkIfItIsExcellentStudent() {
        final int MIN_EXCELLENT_VALUE = 9;
        boolean isExcellentStudent = true;
        for (int grade : academicPerformance) {
            if (grade < MIN_EXCELLENT_VALUE) {
                isExcellentStudent = false;
                break;
            }
        }
        return isExcellentStudent;
    }

}
