package com.epam.calendar.exceptions;

public class CalendarLogicalException extends Exception {
    public CalendarLogicalException() {
    }

    public CalendarLogicalException(String message) {
        super(message);
    }

    public CalendarLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalendarLogicalException(Throwable cause) {
        super(cause);
    }

    public CalendarLogicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
