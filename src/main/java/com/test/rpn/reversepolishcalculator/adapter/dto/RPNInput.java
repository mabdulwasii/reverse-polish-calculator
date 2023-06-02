package com.test.rpn.reversepolishcalculator.adapter.dto;

import java.util.Objects;

public class RPNInput {

    public RPNInput() {
    }

    public RPNInput(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public RPNInput setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RPNInput rpnInput = (RPNInput) o;

        if (!getValue().equals(rpnInput.getValue())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return "RPNInput{" +
                "value='" + value + '\'' +
                '}';
    }
}
