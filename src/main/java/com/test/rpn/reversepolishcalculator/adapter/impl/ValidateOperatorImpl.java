package com.test.rpn.reversepolishcalculator.adapter.impl;

import com.test.rpn.reversepolishcalculator.domain.OperatorFactory;
import com.test.rpn.reversepolishcalculator.domain.exception.InvalidOperatorException;
import com.test.rpn.reversepolishcalculator.usecase.port.ValidateOperator;
import org.springframework.stereotype.Component;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INVALID_OPERATOR;

@Component
public class ValidateOperatorImpl implements ValidateOperator {

    private final OperatorFactory operatorFactory;

    public ValidateOperatorImpl(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;
    }

    @Override
    public boolean isOperator(String op) {
        return operatorFactory.getOperator(op)
                .isPresent();
    }

    @Override
    public int getOperandCount(String op) {
        return operatorFactory.getOperator(op)
                .orElseThrow(() -> new InvalidOperatorException(INVALID_OPERATOR))
                .getOperandCount();
    }

}
