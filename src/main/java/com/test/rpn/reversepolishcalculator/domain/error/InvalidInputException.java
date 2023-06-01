package com.test.rpn.reversepolishcalculator.domain.error;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
