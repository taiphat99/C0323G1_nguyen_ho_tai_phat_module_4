package com.examination.service;

import com.examination.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();
    Category findById(Integer id);
}
