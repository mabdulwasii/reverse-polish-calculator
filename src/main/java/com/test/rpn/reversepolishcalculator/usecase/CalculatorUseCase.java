package com.test.rpn.reversepolishcalculator.usecase;

import com.test.rpn.reversepolishcalculator.adapter.model.RPNResult;
import com.test.rpn.reversepolishcalculator.domain.exception.InvalidInputException;
import com.test.rpn.reversepolishcalculator.domain.exception.InvalidRpnNotationException;
import com.test.rpn.reversepolishcalculator.usecase.port.Operation;
import com.test.rpn.reversepolishcalculator.usecase.port.ValidateOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INPUT_REQUIRED;
import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INVALID_VALUE_INPUT;
import static java.util.Arrays.asList;
import static java.util.Collections.addAll;

@Component
public class CalculatorUseCase {

    private static final Logger log = LoggerFactory.getLogger(CalculatorUseCase.class);
    private final Operation operation;
    private final ValidateOperator validateOperator;

    private final Stack<Double> stack = new Stack<>();

    protected CalculatorUseCase(Operation operation, ValidateOperator validateOperator) {
        this.operation = operation;
        this.validateOperator = validateOperator;
    }

    public RPNResult evaluate(String input) {
        double output = 0;

        String[] tokens = evaluateExpression(input);

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.add(getParsedDouble(token));
            } else if (validateOperator.isOperator(token)) {
                if (!hasValidOperands(getOperator(token).getOperandCount())) {
                    throw new OperandNotEnoughException("Operands not enough");
                }
                output = operation.apply(token, stack);
                stack.add(output);
            } else {
                throw new InvalidInputException(INVALID_VALUE_INPUT + token);
            }
        }

        log.info("Stack size afterwards {}  then {}", stack.size(), stack.peek());
        stack.clear();
        return new RPNResult(output);
    }

    private static double getParsedDouble(String token) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            log.info("Invalid double value");
            throw new NumberFormatException("Invalid double value");
        }

    }

    private String[] evaluateExpression(String input) {
        if (!StringUtils.hasText(input)) {
            throw new InvalidRpnNotationException(INPUT_REQUIRED);
        }
        String[] tokens = input.trim().split(" ");

        List<String> tokenList = new ArrayList<>(tokens.length);
        addAll(tokenList, tokens);
        tokenList.removeAll(asList(null, ""));

        return tokenList.toArray(new String[0]);
    }
}
