package com.hackerrank.restaurant.exceptions;

public class NotEnoughItemException extends RuntimeException {

    /**
     *
     * @param message The exception message
     */
    public NotEnoughItemException(String message) {
        super(message);
    }
}
