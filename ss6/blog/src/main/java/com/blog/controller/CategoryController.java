package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list")
    public ModelAndView showCategoryList(@PageableDefault(value = 0,size = 2,sort = "id") Pageable pageable,
                                         @RequestParam(defaultValue = "") String searchName){
        ModelAndView mav = new ModelAndView("category/list");
        Page<Category> categoryPage = categoryService.findCategoryByNameContaining(pageable, searchName);
        mav.addObject("categoryPage",categoryPage);
        mav.addObject("searchName",searchName);
        return mav;

    }

}
