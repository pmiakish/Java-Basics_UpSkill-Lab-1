package com.epam.simplestclassesandobjects.entity;

import java.util.Objects;

public class Counter {

    private int startValue;
    private int endValue;
    private int currentValue;

    private static final int DEFAULT_START_VALUE = -5;
    private static final int DEFAULT_END_VALUE = 10;

    public Counter(int startValue, int endValue) throws IllegalArgumentException {
        if (startValue == endValue) {
            throw new IllegalArgumentException("Wrong values of counter bounds!");
        }
        this.startValue = currentValue = startValue;
        this.endValue = endValue;
    }

    public Counter() throws IllegalArgumentException {
        this(DEFAULT_START_VALUE, DEFAULT_END_VALUE);
    }

    public void setStartValue(int startValue) {
        this.startValue = currentValue = startValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
        currentValue = startValue;
    }

    public void setCurrentValue(int currentValue) throws IllegalArgumentException {
        if (currentValue > Math.max(startValue, endValue) || currentValue < Math.min(startValue, endValue)) {
            throw new IllegalArgumentException("The specified current value is out of counter bounds!");
        }
        this.currentValue = currentValue;
    }

    public int getStartValue() {
        return startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void increaseCounter() {
        if (currentValue != Math.max(startValue, endValue)) {
            currentValue++;
        } else {
            currentValue = Math.min(startValue, endValue);
        }
    }

    public void decreaseCounter() {
        if (currentValue != Math.min(startValue, endValue)) {
            currentValue--;
        } else {
            currentValue = Math.max(startValue, endValue);
        }
    }

    @Override
    public String toString() {
        return "Counter [current value: " + currentValue + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Counter other = (Counter) obj;
        return startValue == other.startValue &&
                endValue == other.endValue &&
                currentValue == other.currentValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startValue, endValue, currentValue);
    }
}
