package com.test.rpn.reversepolishcalculator.usecase.port;

import java.util.Deque;

public interface Operation {
    double apply(String token, Deque<Double> deque);
}
