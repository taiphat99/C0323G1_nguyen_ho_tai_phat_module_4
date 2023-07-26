package com.blog.service.blog;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable, String searchName);
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
}
