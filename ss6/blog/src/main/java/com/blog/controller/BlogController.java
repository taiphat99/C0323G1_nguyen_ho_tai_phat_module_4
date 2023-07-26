package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.blog.IBlogService;
import com.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/list")
    public ModelAndView getAll(@PageableDefault(value = 0, size = 6, sort = "id") Pageable pageable,
                               @RequestParam(defaultValue = "") String searchName) {
        ModelAndView mav = new ModelAndView("home");
        Page<Blog> blogPage = blogService.findAll(pageable, searchName);
        mav.addObject("blogPage", blogPage);
        mav.addObject("searchName", searchName);
        return mav;
    }

    @GetMapping("/add")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "createForm";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setCreatedDate(Date.valueOf(LocalDate.now()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Add successfully!");
        return "redirect:/list";
    }

    @GetMapping("/searchByName")
    public ModelAndView searchByName(@PageableDefault(value = 0, size = 6, sort = "id") Pageable pageable,
                                     @RequestParam("searchName") String searchName) {
        ModelAndView mav = new ModelAndView("/home");
        Page<Blog> blogPage = blogService.findAll(pageable, searchName);
        mav.addObject("blogPage",blogPage);
        mav.addObject("searchName",searchName);
        mav.addObject("msg",blogPage.getTotalElements() + " records was founded");
        return mav;
    }

//    @ModelAttribute("categories")
//    public String[] categories(){
//        return new String[]{"Sport","Life","Technology","Travel"};
//    }

}
