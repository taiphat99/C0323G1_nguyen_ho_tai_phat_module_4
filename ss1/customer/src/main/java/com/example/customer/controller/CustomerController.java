package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/")
    public String showList(Model model){
    List<Customer> customermList = customerService.getAll();
    model.addAttribute("customerList",customermList);
    return "showList";
    }
    @GetMapping("/showAddForm")
    public String showAddForm(){
        return "showAddForm";
    }
    @PostMapping("/addNewCustomer")
    public String addNewCustomer(@RequestParam int id, @RequestParam String name, @RequestParam String email, Model model){
        Customer customer = new Customer(id, name, email);
        customerService.add(customer);
        List <Customer> customerList = customerService.getAll();
        model.addAttribute("customerList", customerList);
        model.addAttribute("msg","Add successfully!");
        return "showList";
    }
    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int id,Model model){
        Customer customer = customerService.findById(id);
        customerService.delete(customer);
        List <Customer> customerList = customerService.getAll();
        model.addAttribute("customerList", customerList);
        model.addAttribute("msg", "Delete Successfully!");
        return "showList";
    }
}
