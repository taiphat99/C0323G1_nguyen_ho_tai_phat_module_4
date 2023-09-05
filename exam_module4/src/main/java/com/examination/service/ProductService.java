package com.examination.service;

import com.examination.model.Category;
import com.examination.model.Product;
import com.examination.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;
    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> getAll(Pageable pageable, String searchName, String categoryName) {
        return productRepository.findProductByNameContainingAndCategoryNameContaining(pageable,searchName,categoryName);
    }
}
