package com.test.rpn.reversepolishcalculator.domain.constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppConstants {
    private AppConstants() {}

    public static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("(", ")", "+", "-", "%", "/", "*", "SQRT"));

    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String SQRT = "SQRT";
    public static final String EVALUATION_ERROR_CANNOT_DIVIDE_BY_0 = "Evaluation error :: Cannot divide by 0";
    public static final String CANNOT_SQRT_NEGATIVE_NUMBER = "Evaluation error :: Cannot find square root of negative number";
    public static final String INVALID_OPERATOR = "Evaluation error :: Invalid operator";
    public static final String INVALID_RPN_NOTATION = "Evaluation error :: Invalid RPN Notation ";
    public static final String INVALID_VALUE_INPUT = "Evaluation error :: Invalid value Input ";
}
