package com.cookie_session.controller;

import com.cookie_session.dto.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
        public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) Cart cart) {
        return new ModelAndView("cart", "cart", cart);
    }
}
