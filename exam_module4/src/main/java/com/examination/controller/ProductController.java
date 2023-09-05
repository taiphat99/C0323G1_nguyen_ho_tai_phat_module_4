package com.examination.controller;

import com.examination.dto.ProductDto;
import com.examination.model.Category;
import com.examination.model.Product;
import com.examination.service.ICategoryService;
import com.examination.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 0, sort = "id", size = 4) Pageable pageable,
                           @RequestParam(defaultValue = "") String categoryName,
                           @RequestParam(defaultValue = "") String searchName,
                           Model model) {
        Page<Product> productPage = productService.getAll(pageable, searchName, categoryName);
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("searchName", searchName);
        model.addAttribute("productPage", productPage);
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "list";
    }


    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ProductDto productDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new ProductDto().validate(productDto, bindingResult);
        List<Category> categoryList = categoryService.getAll();
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("productDto", productDto);
            return "create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Add successfully!");
        return "redirect:/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam String id, RedirectAttributes redirectAttributes){
        productService.deleteById(Integer.valueOf(id));
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/list";
    }

}
