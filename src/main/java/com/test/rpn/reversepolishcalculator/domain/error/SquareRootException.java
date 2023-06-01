package com.test.rpn.reversepolishcalculator.domain.error;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.CANNOT_SQRT_NEGATIVE_NUMBER;

public class SquareRootException extends ArithmeticException {
    public SquareRootException() {
        super(CANNOT_SQRT_NEGATIVE_NUMBER);
    }
}
