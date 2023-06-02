package com.test.rpn.reversepolishcalculator.usecase;

public class OperandNotEnoughException extends RuntimeException {
    public OperandNotEnoughException(String message) {
        super(message);
    }
}
