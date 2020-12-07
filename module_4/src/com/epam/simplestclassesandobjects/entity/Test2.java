package com.epam.simplestclassesandobjects.entity;

import java.util.Objects;

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

    public Test2() {}

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

    @Override
    public String toString() {
        return "Test2 [a: " + a + "; b: " + b + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Test2 other = (Test2) obj;
        return Double.compare(a, other.a) == 0 && Double.compare(b, other.b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

}
