package com.epam.simplestclassesandobjects;

public class Test1 {

    private double a;
    private double b;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void printA() {
        System.out.println(a);
    }

    public void printB() {
        System.out.println(b);
    }

    public double sumOfVariables() {
        return a + b;
    }

    public double findMaxValueOfVariables() {
        return Math.max(a, b);
    }

    @Override
    public String toString() {
        return "A-value is: " + a + "\nB-value is: " + b + "\n";
    }

}
