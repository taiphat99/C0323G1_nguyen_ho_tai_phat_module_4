package com.demo.service;

import com.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> searchByName(String name);
    void save (Product product);
    Product findById(int id);
    void delete(int id);
}
