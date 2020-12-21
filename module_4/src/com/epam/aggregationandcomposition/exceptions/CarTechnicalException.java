package com.epam.aggregationandcomposition.exceptions;

public class CarTechnicalException extends Exception {
    public CarTechnicalException() {
    }

    public CarTechnicalException(String message) {
        super(message);
    }

    public CarTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarTechnicalException(Throwable cause) {
        super(cause);
    }

    public CarTechnicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
