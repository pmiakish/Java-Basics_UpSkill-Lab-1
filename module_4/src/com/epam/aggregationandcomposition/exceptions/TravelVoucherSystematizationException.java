package com.epam.aggregationandcomposition.exceptions;

public class TravelVoucherSystematizationException extends Exception {
    public TravelVoucherSystematizationException() {
    }

    public TravelVoucherSystematizationException(String message) {
        super(message);
    }

    public TravelVoucherSystematizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TravelVoucherSystematizationException(Throwable cause) {
        super(cause);
    }

    public TravelVoucherSystematizationException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
