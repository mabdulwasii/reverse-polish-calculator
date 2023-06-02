package com.test.rpn.reversepolishcalculator.adapter.impl;

import com.test.rpn.reversepolishcalculator.domain.exception.DivisionByZeroException;
import com.test.rpn.reversepolishcalculator.domain.exception.InvalidOperatorException;
import com.test.rpn.reversepolishcalculator.domain.exception.SquareRootException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static com.test.rpn.reversepolishcalculator.TestConstants.*;

@SpringBootTest
class OperationImplTest {

    @Autowired
    private OperationImpl operation;
    private final Deque<Double> deque = new ArrayDeque<>();

    @BeforeEach
    void setup() {
        Arrays.asList(1.0D, 3D)
                .forEach(deque::push);
    }

    @Test
    void shouldMultiply() {
        double multiply = operation.multiply(left, right);
        Assertions.assertEquals(multiplyResult, multiply);
    }

    @Test
    void shouldSubtract() {
        Assertions.assertEquals(subtractResult, operation.subtract(left, right));
    }

    @Test
    void shouldAdd() {
        Assertions.assertEquals(addResult, operation.add(left, right));
    }

    @Test
    void shouldSquareRoot() {
        Assertions.assertEquals(squareRootResult, operation.squareRoot(left));
    }

    @Test
    void shouldDivide() {
        Assertions.assertEquals(divideResult, operation.divide(left, right));
    }

    @Test
    void shouldThrowExceptionIfNotValidOperator() {
        Assertions.assertThrows(InvalidOperatorException.class,
                () -> operation.apply(INVALID_OPERATOR, deque)
        );
    }

    @Test
    void shouldThrowExceptionIfDivideByZero() {
        Assertions.assertThrows(DivisionByZeroException.class,
                () -> operation.divide(left, 0)
        );
    }

    @Test
    void shouldThrowExceptionIfSquareRootOFNegative() {
        Assertions.assertThrows(SquareRootException.class,
                () -> operation.squareRoot(-1)
        );
    }
}