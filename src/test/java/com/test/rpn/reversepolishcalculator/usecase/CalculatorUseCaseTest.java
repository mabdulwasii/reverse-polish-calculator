package com.test.rpn.reversepolishcalculator.usecase;

import com.test.rpn.reversepolishcalculator.adapter.dto.RPNResult;
import com.test.rpn.reversepolishcalculator.domain.exception.InvalidInputException;
import com.test.rpn.reversepolishcalculator.domain.exception.InvalidRpnNotationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.test.rpn.reversepolishcalculator.TestConstants.VALID_REQUEST;

@SpringBootTest
class CalculatorUseCaseTest {

    @Autowired
    private CalculatorUseCase calculatorUseCase;


    @Test
    void shouldEvaluateSuccessfully() throws Exception {
        RPNResult evaluate = calculatorUseCase.evaluate(VALID_REQUEST);
        Assertions.assertNotNull(evaluate);
        Assertions.assertEquals(evaluate.getResult(), 1);
        Assertions.assertNull(evaluate.getError());
    }

    @Test
    void shouldThrowExceptionIfRequestEmptyOrNull() throws Exception {
        Assertions.assertThrows(InvalidRpnNotationException.class,
                () -> calculatorUseCase.evaluate("")
        );
    }

    @Test
    void shouldThrowExceptionIfRequestIsNull() throws Exception {
        Assertions.assertThrows(InvalidRpnNotationException.class,
                () -> calculatorUseCase.evaluate(null)
        );
    }

    @Test
    void shouldThrowExceptionIfTokensIsNotEnough() throws Exception {
        Assertions.assertThrows(InvalidRpnNotationException.class,
                () -> calculatorUseCase.evaluate("5546747")
        );
    }

    @Test
    void shouldThrowExceptionIfTokensIsNotValid() throws Exception {
        Assertions.assertThrows(InvalidInputException.class,
                () -> calculatorUseCase.evaluate("5 4 &")
        );
    }
}