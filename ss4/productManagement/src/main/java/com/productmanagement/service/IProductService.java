package com.productmanagement.service;

import com.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll() ;
    void delete(Integer id);
    void add(Product product);
    Product findById(Integer id);
    void update( Product product);
}
