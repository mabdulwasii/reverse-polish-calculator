package com.test.rpn.reversepolishcalculator.adapter.controller;

import com.test.rpn.reversepolishcalculator.adapter.model.RPNInput;
import com.test.rpn.reversepolishcalculator.adapter.model.RPNResult;
import com.test.rpn.reversepolishcalculator.domain.error.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INPUT_KEY;
import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.RESPONSE_KEY;

@ControllerAdvice
public class ExceptionController {

    // For UI Pages
    @ExceptionHandler(InvalidRpnNotationException.class)
    public String invalidRpnNotationException(InvalidRpnNotationException ex, Model model) {
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return "index";
    }

    @ExceptionHandler(InvalidOperatorException.class)
    public String invalidOperatorException(InvalidOperatorException ex, Model model) {
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return "index";
    }

    @ExceptionHandler(InvalidInputException.class)
    public String invalidInputException(InvalidInputException ex, Model model) {
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return "index";
    }

    @ExceptionHandler(SquareRootException.class)
    public String squareRootException(SquareRootException ex, Model model) {
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return "index";
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public String divisionByZeroException(DivisionByZeroException ex, Model model) {
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception ex, Model model) {
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult(null, ex.getMessage()));
        return "index";
    }

}
