package com.test.rpn.reversepolishcalculator.adapter.impl;

import com.test.rpn.reversepolishcalculator.domain.Calculator;
import com.test.rpn.reversepolishcalculator.domain.error.InvalidOperatorException;
import com.test.rpn.reversepolishcalculator.usecase.port.Operation;
import org.springframework.stereotype.Component;

import java.util.Stack;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.*;

@Component
public class OperationImpl extends Calculator implements Operation {

    @Override
    public double apply(String operator, Stack<Double> stack) {
        double left;
        double right;

        switch (operator) {
            case ADD -> {
                left = stack.pop();
                right = stack.pop();
                return add(right, left);
            }
            case SUBTRACT -> {
                left = stack.pop();
                right = stack.pop();
                return subtract(right, left);
            }
            case MULTIPLY -> {
                left = stack.pop();
                right = stack.pop();
                return multiply(right, left);
            }
            case DIVIDE -> {
                left = stack.pop();
                right = stack.pop();
                return divide(right, left);
            }
            case SQRT -> {
                right = stack.pop();
                return squareRoot(right);
            }
            default -> throw new InvalidOperatorException(INVALID_OPERATOR + operator);
        }
    }
}
