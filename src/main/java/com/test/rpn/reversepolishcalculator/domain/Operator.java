package com.test.rpn.reversepolishcalculator.domain;

public class Operator {

    private String value;
    private Integer operandCount = 2;

    public Operator(String value, Integer operandCount) {
        this.value = value;
        this.operandCount = operandCount;
    }

    public Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Operator setValue(String value) {
        this.value = value;
        return this;
    }

    public Integer getOperandCount() {
        return operandCount;
    }

    public Operator setOperandCount(Integer operandCount) {
        this.operandCount = operandCount;
        return this;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "value='" + value + '\'' +
                ", operandCount=" + operandCount +
                '}';
    }
}
