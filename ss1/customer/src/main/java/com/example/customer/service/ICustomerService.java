package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    void add(Customer customer);
    void delete(Customer customer);
    Customer findById(int id);
}
