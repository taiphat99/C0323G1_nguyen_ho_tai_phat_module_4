package com.example.customer.repository;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
    void add(Customer customer);
    void delete(Customer customer);
    Customer findById(int id);

}
