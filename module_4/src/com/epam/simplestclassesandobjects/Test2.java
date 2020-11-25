package com.epam.simplestclassesandobjects;

public class Test2 {

    private double a;
    private double b;

    public Test2(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Test2(double commonValue) {
        this(commonValue, commonValue);
    }

    public Test2() {
        this(0.0);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

}
