package com.test.rpn.reversepolishcalculator.domain.exception;

public class InvalidRpnNotationException extends RuntimeException {

    public InvalidRpnNotationException(String message) {
        super(message);
    }
}
