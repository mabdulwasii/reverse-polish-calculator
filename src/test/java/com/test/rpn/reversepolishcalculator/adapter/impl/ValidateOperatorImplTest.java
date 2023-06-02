package com.test.rpn.reversepolishcalculator.adapter.impl;

import com.test.rpn.reversepolishcalculator.usecase.port.ValidateOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.test.rpn.reversepolishcalculator.domain.OperatorFactory.OPERATORS_STRING;
import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.SQRT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ValidateOperatorImplTest {

    @Autowired
    private ValidateOperator validateOperator;

    @Test
    void shouldValidateIsOperator() {
        OPERATORS_STRING.forEach(operator -> {
            boolean isOperator = validateOperator.isOperator(operator);
            assertTrue(isOperator);
        });
    }

    @Test
    void shouldGetOperatorCountRights() {
        OPERATORS_STRING.forEach(operator -> {
            int operandCount = validateOperator.getOperandCount(operator);
            if (operator.equals(SQRT)) {
                assertEquals(operandCount, 1);
            } else {
                assertEquals(operandCount, 2);
            }
        });
    }

}