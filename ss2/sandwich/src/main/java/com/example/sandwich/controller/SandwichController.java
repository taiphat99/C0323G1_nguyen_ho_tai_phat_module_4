package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SandwichController {
    @GetMapping("/")
    public String showMenu() {
        return "menu";
    }

    @PostMapping("/submit")
    public String save(@RequestParam(value = "condiments", required = false) String[] condiments, Model model) {
        if (condiments == null) {
            model.addAttribute("msg", "Select condiments above, please!");
            return "menu";
        }
        model.addAttribute("condiments", condiments);
        return "home";
    }
}
