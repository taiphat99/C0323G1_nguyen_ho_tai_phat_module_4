package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    List<Blog> searchByName(String name);
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
}
