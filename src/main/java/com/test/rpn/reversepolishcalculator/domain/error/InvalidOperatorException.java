package com.test.rpn.reversepolishcalculator.domain.error;


public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException(String message) {
        super(message);
    }
}
