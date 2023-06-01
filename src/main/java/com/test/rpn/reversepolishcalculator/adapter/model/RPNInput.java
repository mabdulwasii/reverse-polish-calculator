package com.test.rpn.reversepolishcalculator.adapter.model;

public class RPNInput {
    private String value;

    public String getValue() {
        return value;
    }

    public RPNInput setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "RPNInput{" +
                "value='" + value + '\'' +
                '}';
    }
}
