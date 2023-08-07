package com.hackerrank.restaurant.exceptions;

public class NoSuchOrderException extends RuntimeException {

    /**
     *
     * @param message The exception message
     */
    public NoSuchOrderException(String message) {
        super(message);
    }
}
