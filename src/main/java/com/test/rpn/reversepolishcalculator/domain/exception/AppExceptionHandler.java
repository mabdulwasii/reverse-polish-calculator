package com.test.rpn.reversepolishcalculator.domain.exception;

import com.test.rpn.reversepolishcalculator.adapter.model.RPNInput;
import com.test.rpn.reversepolishcalculator.adapter.model.RPNResult;
import com.test.rpn.reversepolishcalculator.usecase.OperandNotEnoughException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INPUT_KEY;
import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.RESPONSE_KEY;

@ControllerAdvice
public class AppExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);

    public static final String INDEX_PAGE = "index";

    // For UI Pages
    @ExceptionHandler(InvalidRpnNotationException.class)
    public String invalidRpnNotationException(InvalidRpnNotationException ex, Model model) {
        log.info("InvalidRpnNotationException :: ", ex);
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return INDEX_PAGE;
    }

    @ExceptionHandler(InvalidOperatorException.class)
    public String invalidOperatorException(InvalidOperatorException ex, Model model) {
        log.info("InvalidOperatorException :: ", ex);

        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return INDEX_PAGE;
    }

    @ExceptionHandler(InvalidInputException.class)
    public String invalidInputException(InvalidInputException ex, Model model) {
        log.info("InvalidInputException :: ", ex);
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return INDEX_PAGE;
    }

    @ExceptionHandler(SquareRootException.class)
    public String squareRootException(SquareRootException ex, Model model) {
        log.info("SquareRootException :: ", ex);

        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return INDEX_PAGE;
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public String divisionByZeroException(DivisionByZeroException ex, Model model) {
        log.info("DivisionByZeroException :: ", ex);

        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return INDEX_PAGE;
    }

    @ExceptionHandler(OperandNotEnoughException.class)
    public String operandNotEnoughException(OperandNotEnoughException ex, Model model) {
        log.info("OperandNotEnoughException :: ", ex);

        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return INDEX_PAGE;
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception ex, Model model) {
        log.info("Exception :: ", ex);

        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return INDEX_PAGE;
    }
}
