package com.test.rpn.reversepolishcalculator.domain;

import org.springframework.stereotype.Component;

import java.util.*;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.*;

@Component
public class OperatorFactory {

    protected static final Set<Operator> OPERATOR_SET = new HashSet<>();
    private static final Set<String> OPERATORS_STRING =
            new HashSet<>(Arrays.asList(ADD, SUBTRACT, DIVIDE, MULTIPLY, SQRT));


    static {
        createOperators();
    }

    private static void createOperators() {
        OPERATORS_STRING.forEach(s -> {
            if (s.equals(SQRT)) {
                OPERATOR_SET.add(new Operator(s, 1));
            }
            OPERATOR_SET.add(new Operator(s));
        });
    }

    public Optional<Operator> getOperator(String op) {
        List<Operator> list = OPERATOR_SET.stream()
                .filter(operator -> operator.getValue().equals(op))
                .toList();
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }
}
