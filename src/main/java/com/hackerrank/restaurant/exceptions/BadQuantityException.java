package com.hackerrank.restaurant.exceptions;

public class BadQuantityException extends RuntimeException {

    /**
     *
     * @param message The exception message
     */
    public BadQuantityException(String message) {
        super(message);
    }
}
