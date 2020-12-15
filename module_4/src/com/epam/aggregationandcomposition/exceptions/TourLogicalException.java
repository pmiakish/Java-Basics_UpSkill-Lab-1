package com.epam.aggregationandcomposition.exceptions;

public class TourLogicalException extends Exception {
    public TourLogicalException() {
    }

    public TourLogicalException(String message) {
        super(message);
    }

    public TourLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourLogicalException(Throwable cause) {
        super(cause);
    }

    public TourLogicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
