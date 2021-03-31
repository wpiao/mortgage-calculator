package com.javaccinations.calculator;

public class IllegalUserInputException extends RuntimeException {
    public IllegalUserInputException() {
        super();
    }

    public IllegalUserInputException(String message) {
        super(message);
    }

    public IllegalUserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalUserInputException(Throwable cause) {
        super(cause);
    }
}