package com.test.rpn.reversepolishcalculator.domain.exception;


public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException(String message) {
        super(message);
    }
}
