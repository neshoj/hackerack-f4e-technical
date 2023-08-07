package com.hackerrank.restaurant.exceptions;

public class DuplicateItemEntryException extends RuntimeException {

    /**
     *
     * @param message The exception message
     */
    public DuplicateItemEntryException(String message) {
        super(message);
    }
}
