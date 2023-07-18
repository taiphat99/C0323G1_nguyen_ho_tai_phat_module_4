package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/search")
    public String search(@RequestParam String word, Model model) {
        String searchingWord = word.trim().toLowerCase();
        model.addAttribute("searchingWord",searchingWord);
        String result = dictionaryService.search(searchingWord);
        if (result != null){
            model.addAttribute("result","Meaning:" + result);
        } else {
            model.addAttribute("result", "This word doesn't exist in the Dictionary!");
        }
        return "home";
    }
    @PostMapping("/metaSearch")
    public String metaSearch(@RequestParam String word){
        String searchingWord = word.trim().toLowerCase();
        return "redirect:https://dictionary.cambridge.org/dictionary/english/" + searchingWord;
    }
}
