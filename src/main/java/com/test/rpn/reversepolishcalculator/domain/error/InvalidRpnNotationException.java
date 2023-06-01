package com.test.rpn.reversepolishcalculator.domain.error;

public class InvalidRpnNotationException extends RuntimeException {

    public InvalidRpnNotationException(String message) {
        super(message);
    }
}
