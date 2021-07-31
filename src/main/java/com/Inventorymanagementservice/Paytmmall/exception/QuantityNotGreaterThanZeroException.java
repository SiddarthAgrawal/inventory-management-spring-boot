package com.Inventorymanagementservice.Paytmmall.exception;

public class QuantityNotGreaterThanZeroException extends Exception{

    public QuantityNotGreaterThanZeroException() {
        super();
    }

    public QuantityNotGreaterThanZeroException(String message) {
        super(message);
    }

    public QuantityNotGreaterThanZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuantityNotGreaterThanZeroException(Throwable cause) {
        super(cause);
    }

    protected QuantityNotGreaterThanZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
