package com.examination.service;

import com.examination.model.Category;
import com.examination.model.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface IProductService {
    Product findById(Integer id);
    void deleteById(Integer id);
    void save(Product product);

    Page<Product> getAll(Pageable pageable, String searchName, String categoryName);
}
