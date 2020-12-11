package com.epam.aggregationandcomposition.exceptions;

public class CarLogicalException extends Exception {
    public CarLogicalException() {
    }

    public CarLogicalException(String message) {
        super(message);
    }

    public CarLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarLogicalException(Throwable cause) {
        super(cause);
    }

    public CarLogicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
