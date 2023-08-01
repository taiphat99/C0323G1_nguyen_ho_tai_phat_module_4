package com.blog.service.category;

import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> findCategoryByNameContaining (Pageable pageable, String searchName);
}
