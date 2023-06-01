package com.test.rpn.reversepolishcalculator.usecase;

import com.test.rpn.reversepolishcalculator.adapter.model.RPNResult;
import com.test.rpn.reversepolishcalculator.domain.error.InvalidInputException;
import com.test.rpn.reversepolishcalculator.domain.error.InvalidRpnNotationException;
import com.test.rpn.reversepolishcalculator.usecase.port.Operation;
import com.test.rpn.reversepolishcalculator.usecase.port.ValidateOperator;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INVALID_RPN_NOTATION;
import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INVALID_VALUE_INPUT;

@Component
public class CalculatorUseCase {

    private final Operation operation;
    private final ValidateOperator validateOperator;

    private final Deque<Double> deque = new ArrayDeque<>();

    protected CalculatorUseCase(Operation operation, ValidateOperator validateOperator) {
        this.operation = operation;
        this.validateOperator = validateOperator;
    }

    public RPNResult evaluate(String input) {
        double output = 0;

        

        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                deque.add(Double.parseDouble(token));
            } else if (validateOperator.isOperator(token)){
                        output = operation.apply(token, deque);
                        deque.add(output);
            } else {
                throw new InvalidInputException(INVALID_VALUE_INPUT  + token);
            }
        }
        if(deque.isEmpty()) {
            return new RPNResult(output, "");

        }

        throw new InvalidRpnNotationException(INVALID_RPN_NOTATION + input);
    }
}
