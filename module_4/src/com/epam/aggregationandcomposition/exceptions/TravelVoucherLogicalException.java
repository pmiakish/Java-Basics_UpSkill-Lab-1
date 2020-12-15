package com.epam.aggregationandcomposition.exceptions;

public class TravelVoucherLogicalException extends Exception {
    public TravelVoucherLogicalException() {
    }

    public TravelVoucherLogicalException(String message) {
        super(message);
    }

    public TravelVoucherLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TravelVoucherLogicalException(Throwable cause) {
        super(cause);
    }

    public TravelVoucherLogicalException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
