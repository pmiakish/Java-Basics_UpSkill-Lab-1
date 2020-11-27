package com.epam.simplestclassesandobjects;

public class Counter {

    private int startValue = -3;
    private int endValue = 12;
    private int currentValue;

    public Counter(int startValue, int endValue) {
        this.startValue = currentValue = startValue;
        this.endValue = endValue;
    }

    public Counter() {
        currentValue = startValue;
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

}
