package com.test.rpn.reversepolishcalculator.adapter.controller;


import com.test.rpn.reversepolishcalculator.adapter.dto.RPNInput;
import com.test.rpn.reversepolishcalculator.adapter.dto.RPNResult;
import com.test.rpn.reversepolishcalculator.service.RPNService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.INPUT_KEY;
import static com.test.rpn.reversepolishcalculator.domain.constant.AppConstants.RESPONSE_KEY;

@Controller
public class RpnController {
    private final RPNService service;

    public RpnController(RPNService service) {
        this.service = service;
    }

    @GetMapping({"/"})
    public String index(Model model) {
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, new RPNResult());
        return "index";
    }

    @PostMapping("/")
    public String calculate(@Valid RPNInput input, BindingResult result, Model model) {
        RPNResult response =  service.calculate(input);
        model.addAttribute(INPUT_KEY, new RPNInput());
        model.addAttribute(RESPONSE_KEY, response);
        return "index";
    }

}
