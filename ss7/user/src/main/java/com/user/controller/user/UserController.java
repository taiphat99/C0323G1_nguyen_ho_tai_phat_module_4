package com.user.controller.user;

import com.user.dto.UserDTO;
import com.user.model.User;
import com.user.service.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute UserDTO userDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                          Model model){
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("UserDTO",userDTO);
            return "sign-up";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("msg","Add successfully!");
        return "redirect:/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO",userDTO);
        return "sign-up";
    }
}
