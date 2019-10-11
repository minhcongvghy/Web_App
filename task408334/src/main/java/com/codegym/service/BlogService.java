package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;

import java.util.List;

public interface BlogService {
    Iterable<Blog> findAll();

    Blog finById(Long id);

    void remove(Long id);

    Blog save(Blog blog);

    Iterable<Blog> findAllByCategory(Category category);
}