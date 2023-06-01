package com.test.rpn.reversepolishcalculator.adapter.impl;

import com.test.rpn.reversepolishcalculator.usecase.port.ValidateOperator;
import org.springframework.stereotype.Component;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.OPERATORS;

@Component
public class ValidateOperatorImpl implements ValidateOperator {
    @Override
    public boolean isOperator(String op) {
        return OPERATORS.contains(op);
    }
}
