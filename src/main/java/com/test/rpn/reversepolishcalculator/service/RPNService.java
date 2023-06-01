package com.test.rpn.reversepolishcalculator.service;

import com.test.rpn.reversepolishcalculator.adapter.model.RPNInput;
import com.test.rpn.reversepolishcalculator.adapter.model.RPNResult;
import com.test.rpn.reversepolishcalculator.usecase.CalculatorUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RPNService {

    private final Logger logger = LoggerFactory.getLogger(RPNService.class);

    private final CalculatorUseCase useCase;

    public RPNService(CalculatorUseCase useCase) {
        this.useCase = useCase;
    }

    public RPNResult calculate(RPNInput input) {
        logger.info ("RPNService::input {} ", input);
        return useCase.evaluate(input.getValue());
    }
}
