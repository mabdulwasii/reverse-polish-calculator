package com.test.rpn.reversepolishcalculator.domain.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
