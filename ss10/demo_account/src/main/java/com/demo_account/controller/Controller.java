package com.demo_account.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("")
    public String signUp(){
        return "sign-up";
    }
}
