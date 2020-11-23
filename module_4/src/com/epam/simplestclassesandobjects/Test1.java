package com.epam.simplestclassesandobjects;

public class Test1 {

    private double a;
    private double b;

    public void setA(double aValue) {
        a = aValue;
    }

    public void setB(double bValue) {
        b = bValue;
    }

    public void printA() {
        System.out.println(a);
    }

    public void printB() {
        System.out.println(b);
    }

    public double sumAandB() {
        return a + b;
    }

    public double findMaxValue() {
        return Math.max(a, b);
    }

}
