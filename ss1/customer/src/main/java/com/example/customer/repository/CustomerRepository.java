package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Danny", "danny@gmail.com"));
        customerList.add(new Customer(2, "Louis", "louis@gmail.com"));
        customerList.add(new Customer(3, "Bully", "bully@gmail.com"));
        customerList.add(new Customer(4, "Jackie", "jackie@gmail.com"));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerList.remove(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer c : customerList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }


}
