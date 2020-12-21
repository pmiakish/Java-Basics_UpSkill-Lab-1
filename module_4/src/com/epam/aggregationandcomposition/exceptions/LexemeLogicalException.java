package com.epam.aggregationandcomposition.exceptions;

public class LexemeLogicalException extends Exception {
    public LexemeLogicalException() {
    }

    public LexemeLogicalException(String message) {
        super(message);
    }

    public LexemeLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LexemeLogicalException(Throwable cause) {
        super(cause);
    }

    public LexemeLogicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
