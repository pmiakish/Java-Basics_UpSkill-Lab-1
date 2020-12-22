package com.epam.calendar.util.init;

import com.epam.calendar.entity.Calendar;
import com.epam.calendar.entity.HolidayType;
import com.epam.calendar.exceptions.CalendarLogicalException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarInitializer {

    private static final String[] PUBLIC_HOLIDAYS = {"01-01", "01-02", "01-07", "03-08", "05-01", "05-09", "07-03",
            "11-07", "12-25"};
    private static final int NUMBER_OF_DAYS_FROM_SUNDAY_TO_SATURDAY = 6;

    public static void addHolidays(Calendar calendar) throws CalendarLogicalException {
        if (calendar != null) {
            for (String publicHoliday : PUBLIC_HOLIDAYS) {
                calendar.addHoliday(LocalDate.parse(calendar.getCalendarYear().getValue() + "-" + publicHoliday),
                        HolidayType.PUBLIC_HOLIDAY);
            }

            LocalDate date = LocalDate.of(calendar.getCalendarYear().getValue(), 1, 1);
            int numberOfDaysInYear = calendar.getCalendarYear().length();
            int i = 0;
            while (i < numberOfDaysInYear) {
                if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    if (!calendar.isHoliday(date)) {
                        calendar.addHoliday(date, HolidayType.SATURDAY);
                    }
                    date = date.plusDays(1);
                    i++;
                    if (!calendar.isHoliday(date)) {
                        calendar.addHoliday(date, HolidayType.SUNDAY);
                    }
                    date = date.plusDays(NUMBER_OF_DAYS_FROM_SUNDAY_TO_SATURDAY);
                    i += NUMBER_OF_DAYS_FROM_SUNDAY_TO_SATURDAY;
                }
                else {
                    date = date.plusDays(1); // only while the first saturday is not found
                    i++;
                }
            }
        } else {
            throw new CalendarLogicalException("Can't initialize the holidays of the calendar!");
        }
    }

}
