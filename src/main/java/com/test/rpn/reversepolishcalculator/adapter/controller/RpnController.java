package com.test.rpn.reversepolishcalculator.adapter.controller;


import com.test.rpn.reversepolishcalculator.adapter.model.RPNInput;
import com.test.rpn.reversepolishcalculator.adapter.model.RPNResult;
import com.test.rpn.reversepolishcalculator.service.RPNService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RpnController {

    private final RPNService service;

    public RpnController(RPNService service) {
        this.service = service;
    }

    @GetMapping({"/", "/calculate"})
    public String index(Model model) {
        model.addAttribute("input", new RPNInput());
        model.addAttribute("result", new RPNResult());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(Model model, @ModelAttribute("input") RPNInput input) {

        RPNResult result =  service.calculate(input);
        model.addAttribute("input", new RPNInput());
        model.addAttribute("result", result);
        return "index";
    }

}
