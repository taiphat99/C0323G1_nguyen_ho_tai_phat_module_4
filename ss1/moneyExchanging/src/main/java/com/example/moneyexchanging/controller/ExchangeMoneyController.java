package com.example.moneyexchanging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeMoneyController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping("/exchangeMoney")
    public String exchangeMoney(@RequestParam double rate, @RequestParam double amountOfMoney, Model model){
        double result = amountOfMoney*rate;
        model.addAttribute("rate",rate);
        model.addAttribute("amountOfMoney",amountOfMoney);
        model.addAttribute("result",result);
        return "home";
    }
}
