package com.woniu.exception;

public class DrugStockIsNotEnough extends RuntimeException {
    public DrugStockIsNotEnough(String message) {
        super(message);
    }

    public DrugStockIsNotEnough(String message, Throwable cause) {
        super(message, cause);
    }

    public DrugStockIsNotEnough(Throwable cause) {
        super(cause);
    }

    protected DrugStockIsNotEnough(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
