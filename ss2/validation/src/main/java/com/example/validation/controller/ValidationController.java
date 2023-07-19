package com.example.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller

public class ValidationController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;
    public ValidationController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("/")
    String getValidation(){
        return "form";
    }
    @PostMapping("/validation")
    String validateEmail(@RequestParam("email") String email,@RequestParam("name") String name, Model model){
        boolean isValid = this.validate(email);
        if(!isValid){
            model.addAttribute("invalidEmailMsg","Invalid Email!");
            return "form";
        }
        model.addAttribute("name",name);
        return "home";
    }

    private boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
