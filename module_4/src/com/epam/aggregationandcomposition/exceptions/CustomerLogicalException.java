package com.epam.aggregationandcomposition.exceptions;

public class CustomerLogicalException extends Exception {
    public CustomerLogicalException() {
    }

    public CustomerLogicalException(String message) {
        super(message);
    }

    public CustomerLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerLogicalException(Throwable cause) {
        super(cause);
    }

    public CustomerLogicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
