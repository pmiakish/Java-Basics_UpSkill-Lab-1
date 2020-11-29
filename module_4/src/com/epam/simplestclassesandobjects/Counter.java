package com.epam.simplestclassesandobjects;

import java.util.Objects;

public class Counter {

    private int startValue;
    private int endValue;
    private int currentValue;

    public Counter(int startValue, int endValue) {
        this.startValue = currentValue = startValue;
        this.endValue = endValue;
    }

    public Counter() {
        this(-5, 10);
    }

    public void setStartValue(int startValue) {
        this.startValue = currentValue = startValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
        currentValue = startValue;
    }

    public void setCurrentValue(int currentValue) {
        try {
            if (currentValue > Math.max(startValue, endValue) || currentValue < Math.min(startValue, endValue)) {
                throw new Exception("The specified current value is out of bounds of the counter!");
            }
            this.currentValue = currentValue;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

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
