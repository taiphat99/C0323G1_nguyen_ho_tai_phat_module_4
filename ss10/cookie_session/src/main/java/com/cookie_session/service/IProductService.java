package com.cookie_session.service;

import com.cookie_session.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
