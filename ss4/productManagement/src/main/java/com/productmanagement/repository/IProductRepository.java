package com.productmanagement.repository;

import com.productmanagement.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> getAll();

    void delete(Integer id);

    void add(Product product);

    Product findById(Integer id);

    void update( Product product);
}
