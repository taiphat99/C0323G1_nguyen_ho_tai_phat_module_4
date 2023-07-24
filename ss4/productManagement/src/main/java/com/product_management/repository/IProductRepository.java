package com.product_management.repository;

import com.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void delete(Integer id);

    void add(Product product);

    Product findById(Integer id);

    void update( Product product);
}
