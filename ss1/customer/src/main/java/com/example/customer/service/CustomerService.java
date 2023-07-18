package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository  customerRepository;
    @Override
    public List<Customer> getAll(){
        return customerRepository.getAll();
    }
    @Override
    public void add(Customer customer){
        customerRepository.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}
