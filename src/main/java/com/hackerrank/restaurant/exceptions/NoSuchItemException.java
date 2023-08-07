package com.hackerrank.restaurant.exceptions;

public class NoSuchItemException extends RuntimeException {

    /**
     *
     * @param message The exception message
     */
    public NoSuchItemException(String message) {
        super(message);
    }
}
