package com.test.rpn.reversepolishcalculator.adapter.model;

public class RPNResult {
    private double result;
    private String errorMessage;

    public RPNResult(double result, String errorMessage) {
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public RPNResult() {}

    public double getResult() {
        return result;
    }

    public RPNResult setResult(double result) {
        this.result = result;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public RPNResult setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public String toString() {
        return "RPNResult{" +
                "result=" + result +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
