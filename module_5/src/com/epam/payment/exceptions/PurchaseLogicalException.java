package com.epam.payment.exceptions;

public class PurchaseLogicalException extends Exception {
    public PurchaseLogicalException() {
    }

    public PurchaseLogicalException(String message) {
        super(message);
    }

    public PurchaseLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public PurchaseLogicalException(Throwable cause) {
        super(cause);
    }

    public PurchaseLogicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
