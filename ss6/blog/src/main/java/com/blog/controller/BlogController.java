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
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView searchByName(@PageableDefault(value = 0, size = 4, sort = "id") Pageable pageable,
                                     @RequestParam(defaultValue = "") String searchName) {
        ModelAndView mav = new ModelAndView("blog/list");
        Page<Blog> blogPage = blogService.findAll(pageable, searchName);
        mav.addObject("blogPage",blogPage);
        mav.addObject("searchName",searchName);
        return mav;
    }

    @GetMapping("/add")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "blog/createForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setCreatedDate(Date.valueOf(LocalDate.now()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Add successfully!");
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute(blog);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "blog/editForm";
    }
    @PostMapping("update")
    public String update(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes ){
        blog.setUpdatedDate(Date.valueOf(LocalDate.now()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Update successfully!");
        return "redirect:/blog/list";
    }
    @GetMapping("delete")
    public String remove(@RequestParam int id,RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/blog/list";
    }

}
