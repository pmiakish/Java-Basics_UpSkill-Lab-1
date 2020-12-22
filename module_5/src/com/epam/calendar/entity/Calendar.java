package com.epam.calendar.entity;

import com.epam.calendar.exceptions.CalendarLogicalException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calendar {

    private final List<Holiday> holidays = new ArrayList<>();
    private Year calendarYear;

    public Calendar(Year calendarYear) {
        this.calendarYear = calendarYear;
    }

    public Calendar() {
        this(Year.now());
    }

    public void addHoliday(LocalDate date, HolidayType type) throws CalendarLogicalException {
        if (date != null && date.getYear() == calendarYear.getValue() && type != null && !isHoliday(date)) {
            holidays.add(new Holiday(date, type));
        } else {
            throw new CalendarLogicalException("Incorrect parameters. Can't add the holiday!");
        }
    }

    public void removeHoliday(int index) throws CalendarLogicalException {
        if (holidays.size() > 0 && index >= 0 && index < holidays.size() - 1) {
            holidays.remove(index);
        } else {
            throw new CalendarLogicalException("Can't remove the last holiday because it does not exist!");
        }
    }

    public void removeLastHoliday() throws CalendarLogicalException {
        if (holidays.size() > 0) {
            holidays.remove(holidays.size() - 1);
        } else {
            throw new CalendarLogicalException("Can't remove the last holiday because it does not exist!");
        }
    }

    public Year getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(Year calendarYear) throws CalendarLogicalException {
        if (calendarYear != null) {
            this.calendarYear = calendarYear;
        } else {
            throw new CalendarLogicalException("Incorrect parameter. Can't change the year of the calendar!");
        }
    }

    public boolean isHoliday(LocalDate date) {
        if (date != null) {
            return holidays.stream().anyMatch(holiday -> holiday.getDate().equals(date));
        }
        return false;
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
