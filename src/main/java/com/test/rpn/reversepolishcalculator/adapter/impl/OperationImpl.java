package com.test.rpn.reversepolishcalculator.adapter.impl;

import com.test.rpn.reversepolishcalculator.domain.Calculator;
import com.test.rpn.reversepolishcalculator.domain.error.InvalidOperatorException;
import com.test.rpn.reversepolishcalculator.usecase.port.Operation;
import org.springframework.stereotype.Component;

import java.util.Deque;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.*;

@Component
public class OperationImpl extends Calculator implements Operation {

    @Override
    public double apply(String operator, Deque<Double> deque) {
        double left;
        double right;

        switch (operator) {
            case ADD -> {
                left = deque.pop();
                right = deque.pop();
                return add(right, left);
            }
            case SUBTRACT -> {
                left = deque.pop();
                right = deque.pop();
                return subtract(right, left);
            }
            case MULTIPLY -> {
                left = deque.pop();
                right = deque.pop();
                return multiply(right, left);
            }
            case DIVIDE -> {
                left = deque.pop();
                right = deque.pop();
                return divide(right, left);
            }
            case SQRT -> {
                right = deque.pop();
                return squareRoot(right);
            }
            default -> throw new InvalidOperatorException(INVALID_OPERATOR + operator);
        }
    }
}
