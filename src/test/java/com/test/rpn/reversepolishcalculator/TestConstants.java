package com.test.rpn.reversepolishcalculator;

public class TestConstants {

    private TestConstants() {
    }

    public static final String VALID_REQUEST = "5 3 2 + * SQRT 5 /";
    public static final String INVALID_REQUEST = "5 3 4 + * +";

    public static final double left = 4;
    public static final double right = 2;
    public static final double divideResult = 2;
    public static final double subtractResult = 2;
    public static final double squareRootResult = 2;
    public static final double addResult = 6;
    public static final double multiplyResult = 8;
    public static final String INVALID_OPERATOR = "@";

}
