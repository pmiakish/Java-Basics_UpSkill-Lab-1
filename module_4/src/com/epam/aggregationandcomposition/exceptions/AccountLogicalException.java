package com.epam.aggregationandcomposition.exceptions;

public class AccountLogicalException extends Exception {
    public AccountLogicalException() {
    }

    public AccountLogicalException(String message) {
        super(message);
    }

    public AccountLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountLogicalException(Throwable cause) {
        super(cause);
    }

    public AccountLogicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
