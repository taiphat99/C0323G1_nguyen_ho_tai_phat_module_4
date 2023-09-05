package com.examination.repository;

import com.examination.model.Category;
import com.examination.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Integer> {


    Page<Product> findProductByNameContainingAndCategoryNameContaining(Pageable pageable, String name, String categoryName);



}
