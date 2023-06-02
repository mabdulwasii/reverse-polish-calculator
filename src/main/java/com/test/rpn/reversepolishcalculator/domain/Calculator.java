package com.test.rpn.reversepolishcalculator.domain;

import com.test.rpn.reversepolishcalculator.domain.exception.DivisionByZeroException;
import com.test.rpn.reversepolishcalculator.domain.exception.SquareRootException;

public abstract class Calculator {
    public double multiply(double a, double b) {
        return a * b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double squareRoot(double a) {
        if(a < 0) {
            throw new SquareRootException();
        }
        return Math.sqrt(a);
    }

    public double divide(double a, double b) {
        if(b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }

}
