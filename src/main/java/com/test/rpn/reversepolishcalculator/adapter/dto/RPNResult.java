package com.test.rpn.reversepolishcalculator.adapter.dto;

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

    public String getError() {
        return error;
    }

    public RPNResult setError(String error) {
        this.error = error;
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
