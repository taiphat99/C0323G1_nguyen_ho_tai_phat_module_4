package com.cookie_session.controller;
import com.cookie_session.dto.Cart;
import com.cookie_session.model.Product;
import com.cookie_session.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart initCart(){
        return new Cart();
    }
    @Autowired
    private IProductService productService;
    @RequestMapping("")
    public ModelAndView showList(){
        ModelAndView mav = new ModelAndView("shop");
        mav.addObject("productList",productService.findAll());
        return mav;
    }
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute(value = "cart") Cart cart){
        Product product = productService.findById(id);
        if(product!=null){
            cart.addProduct(product);
        }
        return "redirect:/cart";
    }
}
