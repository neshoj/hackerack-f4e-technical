package com.hackerrank.restaurant.exceptions;

public class EmptyOrderException extends RuntimeException {

    /**
     *
     * @param message The exception message
     */
    public EmptyOrderException(String message) {
        super(message);
    }
}
