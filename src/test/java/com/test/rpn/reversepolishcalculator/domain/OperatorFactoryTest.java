package com.test.rpn.reversepolishcalculator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.test.rpn.reversepolishcalculator.TestConstants.INVALID_OPERATOR;
import static com.test.rpn.reversepolishcalculator.domain.OperatorFactory.OPERATORS_STRING;

@SpringBootTest
class OperatorFactoryTest {

    @Autowired
    private OperatorFactory operatorFactory;

    @Test
    void shouldGetAllValidOperators() {
        OPERATORS_STRING
                .forEach(ops -> {
                    Optional<Operator> operator = operatorFactory.getOperator(ops);
                    Assertions.assertTrue(operator.isPresent());
                });
    }

    @Test
    void validateNotOperators() {
        Optional<Operator> operator = operatorFactory.getOperator(INVALID_OPERATOR);
        Assertions.assertFalse(operator.isPresent());
    }

}