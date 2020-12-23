package com.epam.calendar.entity;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calendar {

    private final List<Holiday> holidays = new ArrayList<>();
    private Year calendarYear;

    public Calendar(Year calendarYear) {
        this.calendarYear = Objects.requireNonNull(calendarYear, "Can't create the calendar because year-field" +
                " is null.");
    }

    public Calendar() {
        this(Year.now());
    }

    public void addHoliday(LocalDate date, HolidayType type) throws IllegalArgumentException, NullPointerException {
        Objects.requireNonNull(date, "Can't add the holiday because the date is null!");
        Objects.requireNonNull(type, "Can't add the holiday because its type is null!");
        if (!isHoliday(date)) {
            if (date.getYear() == calendarYear.getValue()) {
                holidays.add(new Holiday(date, type));
            } else {
                throw new IllegalArgumentException("Wrong the year value. Can't add the holiday!");
            }
        }
    }

    public void removeHoliday(int index) throws IllegalArgumentException {
        if (holidays.size() > 0 && index >= 0 && index < holidays.size() - 1) {
            holidays.remove(index);
        } else {
            throw new IllegalArgumentException("Can't remove the last holiday because it does not exist!");
        }
    }

    public void removeLastHoliday() throws IllegalArgumentException {
        if (holidays.size() > 0) {
            holidays.remove(holidays.size() - 1);
        } else {
            throw new IllegalArgumentException("Can't remove the last holiday because it does not exist!");
        }
    }

    public Year getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(Year calendarYear) throws NullPointerException {
        this.calendarYear = Objects.requireNonNull(calendarYear, "Can't change the year of the calendar because " +
                "the year is null!");
    }

    private boolean isHoliday(LocalDate date) {
        return holidays.stream().anyMatch(holiday -> holiday.getDate().equals(date));
    }

    private class Holiday {

        private LocalDate date;
        private HolidayType type;

        private Holiday(LocalDate date, HolidayType type) {
            this.date = date;
            this.type = type;
        }

        private LocalDate getDate() {
            return date;
        }

        private void setDate(LocalDate date) {
            this.date = date;
        }

        private HolidayType getType() {
            return type;
        }

        private void setType(HolidayType type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return date + " is " + type + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Holiday other = (Holiday) o;
            return Objects.equals(date, other.date) &&
                    type == other.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(date, type);
        }
    }

    @Override
    public String toString() {
        return "Calendar [year " + calendarYear + "] contains the holidays:\n" +
                holidays.stream().map(Holiday::toString).reduce("", String::concat);
    }
}
