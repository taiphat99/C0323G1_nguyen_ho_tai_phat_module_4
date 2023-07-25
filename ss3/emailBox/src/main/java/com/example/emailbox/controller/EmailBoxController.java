package com.example.emailbox.controller;

import com.example.emailbox.model.EmailBox;
import com.example.emailbox.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailBoxController {
    @Autowired
    private IEmailService emailService;
    @ModelAttribute("languages")
    public String[] getLanguage(){
        return new String[]{"English","Japanese","Chinese","Vietnamese"};
    }
    @ModelAttribute("pageSizeTypes")
    public int[] getPageSize(){
        return new int[]{5,10,15,20,25};
    }
    @GetMapping("/")
    public String showEditForm(Model model){
        model.addAttribute("emailBox",emailService.getEmailBox());
        return "edit";
    }


    @PostMapping("update")
    public String editEmailBox(@ModelAttribute("emailBox") EmailBox emailBox, Model model){
        emailService.update(emailBox);
        model.addAttribute("emailBox",emailBox);
        return "home";
    }

}
