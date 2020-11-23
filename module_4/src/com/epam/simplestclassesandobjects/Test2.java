package com.epam.simplestclassesandobjects;

public class Test2 {

    private double a;
    private double b;

    public Test2(double aValue, double bValue) {
        a = aValue;
        b = bValue;
    }

    public Test2(double abValue) {
        this(abValue, abValue);
    }

    public Test2() {
        this(0.0);
    }

    public void setA(double aValue) {
        a = aValue;
    }

    public void setB(double bValue) {
        b = bValue;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

}
