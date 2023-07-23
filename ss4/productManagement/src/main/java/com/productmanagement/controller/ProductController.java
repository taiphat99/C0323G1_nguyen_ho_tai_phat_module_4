package com.productmanagement.controller;

import com.productmanagement.model.Product;
import com.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView mav = new ModelAndView("list");
        List<Product> productList = productService.getAll();
        mav.addObject("productList", productList);
        return mav;
    }

    @GetMapping("/add")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "createForm";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("msg", "Add successfully!");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam ("id") int id,Model model){
        productService.delete(id);
        model.addAttribute("productList",productService.getAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "editForm";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("msg","Edit successfully!");
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String showDetailProduct(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "detailProduct";
    }

    @ModelAttribute("brands")
    public String[] getBrands() {
        return new String[]{"Apple", "Samsung", "Xiaomi"};
    }


}
