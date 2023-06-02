package com.test.rpn.reversepolishcalculator.service;

import com.test.rpn.reversepolishcalculator.adapter.dto.RPNInput;
import com.test.rpn.reversepolishcalculator.adapter.dto.RPNResult;
import com.test.rpn.reversepolishcalculator.usecase.CalculatorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.test.rpn.reversepolishcalculator.TestConstants.VALID_REQUEST;

@SpringBootTest
class RPNServiceTest {

    @Autowired
    RPNService service;

    @Autowired
    CalculatorUseCase useCase;

    @Test
    void shouldCalculate() {
        RPNInput rpnInput = new RPNInput(VALID_REQUEST);
        RPNResult calculate = service.calculate(rpnInput);
        Assertions.assertNotNull(calculate);
        Assertions.assertEquals(calculate.getResult(), 1);
        Assertions.assertNull(calculate.getError());
    }


}