package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("operation") String operation,
                            @RequestParam(value = "firstParam", required = false) String firstParam,
                            @RequestParam(value = "secondParam",required = false) String secondParam, Model model) {
        if (firstParam == null || secondParam == null|| firstParam.equals("")||secondParam.equals("")) {
            model.addAttribute("msg", "Enter number please!");
        } else {
            double result;
            double param1 = Double.parseDouble(firstParam);
            double param2 = Double.parseDouble(secondParam);
            switch (operation) {
                case "+":
                    model.addAttribute("param1", param1);
                    model.addAttribute("param2", param2);
                    result = param1 + param2;
                    model.addAttribute("result", result);
                    break;
                case "-":
                    model.addAttribute("param1", param1);
                    model.addAttribute("param2", param2);
                    result = param1 - param2;
                    model.addAttribute("result", result);
                    break;
                case "*":
                    model.addAttribute("param1", param1);
                    model.addAttribute("param2", param2);
                    result = param1 * param2;
                    model.addAttribute("result", result);
                    break;
                case "/":
                    if (param2 != 0) {
                        model.addAttribute("param1", param1);
                        model.addAttribute("param2", param2);
                        result = param1 / param2;
                        model.addAttribute("result", result);
                    } else {
                        model.addAttribute("msg", "Cannot be divided by 0!");
                    }
            }
        }
        return "calculator";
    }
}
