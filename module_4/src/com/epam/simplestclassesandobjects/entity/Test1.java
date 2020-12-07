package com.epam.simplestclassesandobjects.entity;

import java.util.Objects;

public class Test1 {

    private double a;
    private double b;

    public Test1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Test1() {}

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

    public void printA() {
        System.out.println("A-value is: " + a);
    }

    public void printB() {
        System.out.println("B-value is: " + b);
    }

    public double sumOfVariables() {
        return a + b;
    }

    public double findMaxValueOfVariables() {
        return Math.max(a, b);
    }

    @Override
    public String toString() {
        return "Test1 [a: " + a + "; b: " + b + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Test1 other = (Test1) obj;
        return Double.compare(a, other.a) == 0 && Double.compare(b, other.b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
