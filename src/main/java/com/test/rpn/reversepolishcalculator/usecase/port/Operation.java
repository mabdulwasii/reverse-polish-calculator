package com.test.rpn.reversepolishcalculator.usecase.port;

import java.util.Stack;

public interface Operation {
    double apply(String operator, Stack<Double> stack);
}
