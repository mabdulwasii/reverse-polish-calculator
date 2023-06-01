package com.test.rpn.reversepolishcalculator.adapter.model;

public class RPNResult {
    private Double result;
    private String error;

    public RPNResult(Double result, String error) {
        this.result = result;
        this.error = error;
    }

    public RPNResult(Double result) {
        this.result = result;
    }

    public RPNResult() {}

    public Double getResult() {
        return result;
    }

    public RPNResult setResult(Double result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "RPNResult{" +
                "result=" + result +
                "error=" + error +
                '}';
    }
}
