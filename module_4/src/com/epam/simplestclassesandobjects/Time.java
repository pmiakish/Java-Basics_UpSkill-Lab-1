package com.epam.simplestclassesandobjects;

public class Time {

    private int hour;
    private int minute;
    private int second;
    private static final int MAX_HOUR_VALUE = 24;
    private static final int MAX_MINUTE_AND_SECOND_VALUE = 60;

    public Time(int hour, int minute, int second) {
        if (hour >= 0 && hour < MAX_HOUR_VALUE) {
            this.hour = hour;
        }
        if (minute >= 0 && minute < MAX_MINUTE_AND_SECOND_VALUE) {
            this.minute =  minute;
        }
        if (second >= 0 && second < MAX_MINUTE_AND_SECOND_VALUE) {
            this.second =  second;
        }
    }

    public Time() {}

    public void setTime(int hour, int minute, int second) {
        if (hour >= 0 && hour < MAX_HOUR_VALUE) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
        if (minute >= 0 && minute < MAX_MINUTE_AND_SECOND_VALUE) {
            this.minute =  minute;
        } else {
            this.minute = 0;
        }
        if (second >= 0 && second < MAX_MINUTE_AND_SECOND_VALUE) {
            this.second =  second;
        } else {
            this.second = 0;
        }
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < MAX_HOUR_VALUE) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < MAX_MINUTE_AND_SECOND_VALUE) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second < MAX_MINUTE_AND_SECOND_VALUE) {
            this.second = second;
        } else {
            this.second = 0;
        }
    }

    public void addHour(int numberOfHours) {
        int newHourValue = hour + numberOfHours;
        if (newHourValue >= MAX_HOUR_VALUE) {
            hour = newHourValue % MAX_HOUR_VALUE;
        } else if (newHourValue >= 0) {
            hour = newHourValue;
        } else if (Math.abs(newHourValue) >= MAX_HOUR_VALUE) {
            hour = MAX_HOUR_VALUE - (Math.abs(newHourValue) % MAX_HOUR_VALUE);
        } else {
            hour = MAX_HOUR_VALUE - Math.abs(newHourValue);
        }
    }

    public void addMinute(int numberOfMinutes) {
        int newMinuteValue = minute + numberOfMinutes;
        if (newMinuteValue >= MAX_MINUTE_AND_SECOND_VALUE) {
            minute = newMinuteValue % MAX_MINUTE_AND_SECOND_VALUE;
            addHour(newMinuteValue / MAX_MINUTE_AND_SECOND_VALUE);
        } else if (newMinuteValue >= 0) {
            minute = newMinuteValue;
        } else if (Math.abs(newMinuteValue) >= MAX_MINUTE_AND_SECOND_VALUE) {
            minute = MAX_MINUTE_AND_SECOND_VALUE - (Math.abs(newMinuteValue) % MAX_MINUTE_AND_SECOND_VALUE);
            addHour((newMinuteValue / MAX_MINUTE_AND_SECOND_VALUE) - 1);
        } else {
            minute = MAX_MINUTE_AND_SECOND_VALUE - Math.abs(newMinuteValue);
            addHour(-1);
        }
    }

    public void addSecond(int numberOfSeconds) {
        int newSecondValue = second + numberOfSeconds;
        if (newSecondValue >= MAX_MINUTE_AND_SECOND_VALUE) {
            second = newSecondValue % MAX_MINUTE_AND_SECOND_VALUE;
            addMinute(newSecondValue / MAX_MINUTE_AND_SECOND_VALUE);
        } else if (newSecondValue >= 0) {
            second = newSecondValue;
        } else if (Math.abs(newSecondValue) >= MAX_MINUTE_AND_SECOND_VALUE) {
            second = MAX_MINUTE_AND_SECOND_VALUE - (Math.abs(newSecondValue) % MAX_MINUTE_AND_SECOND_VALUE);
            addMinute((newSecondValue / MAX_MINUTE_AND_SECOND_VALUE) - 1);
        } else {
            second = MAX_MINUTE_AND_SECOND_VALUE - Math.abs(newSecondValue);
            addMinute(-1);
        }
    }

    @Override
    public String toString() {
        return String.format("Time [%02dh : %02dm : %02ds]", hour, minute, second);
    }

}
