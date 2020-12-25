package com.epam.calendar.start;

import com.epam.calendar.entity.Calendar;
import com.epam.calendar.util.init.CalendarInitializer;

public class CalendarController {
    public static void main(String[] args) {
        try {
            Calendar calendar = new Calendar();
            CalendarInitializer.addHolidays(calendar);
            System.out.println(calendar);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
