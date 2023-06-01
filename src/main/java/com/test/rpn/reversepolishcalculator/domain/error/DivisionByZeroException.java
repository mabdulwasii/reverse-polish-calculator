package com.test.rpn.reversepolishcalculator.domain.error;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.EVALUATION_ERROR_CANNOT_DIVIDE_BY_0;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException() {
        super(EVALUATION_ERROR_CANNOT_DIVIDE_BY_0);
    }
}
