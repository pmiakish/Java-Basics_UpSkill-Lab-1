package com.epam.aggregationandcomposition.exceptions;

public class StateLogicalException extends Exception {
    public StateLogicalException() {
    }

    public StateLogicalException(String message) {
        super(message);
    }

    public StateLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public StateLogicalException(Throwable cause) {
        super(cause);
    }

    public StateLogicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
