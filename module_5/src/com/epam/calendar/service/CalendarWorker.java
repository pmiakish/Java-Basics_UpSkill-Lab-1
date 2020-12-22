package com.epam.calendar.service;

import com.epam.calendar.entity.Calendar;
import com.epam.calendar.exceptions.CalendarLogicalException;
import com.epam.calendar.util.init.CalendarInitializer;

public class CalendarWorker {
    public static void main(String[] args) {
        try {
            Calendar calendar = new Calendar();
            CalendarInitializer.addHolidays(calendar);
            System.out.println(calendar);
        } catch (CalendarLogicalException e) {
            e.printStackTrace();
        }
    }
}
