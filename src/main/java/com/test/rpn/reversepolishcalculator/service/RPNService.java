package com.test.rpn.reversepolishcalculator.service;

import com.test.rpn.reversepolishcalculator.adapter.dto.RPNInput;
import com.test.rpn.reversepolishcalculator.adapter.dto.RPNResult;
import com.test.rpn.reversepolishcalculator.usecase.CalculatorUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RPNService {

    private static final Logger log = LoggerFactory.getLogger(RPNService.class);

    private final CalculatorUseCase useCase;

    public RPNService(CalculatorUseCase useCase) {
        this.useCase = useCase;
    }

    public RPNResult calculate(RPNInput input) {
        log.info ("RPNService::input {} ", input);
        return useCase.evaluate(input.getValue());
    }
}
