package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.BlogCategory;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.List;

@RestController
public class ApiBlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("api/blogs")
    public ResponseEntity<List<Blog>> listAllBlog(){
        List<Blog> blogList = (List<Blog>) blogService.findAll();

        if(blogList.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
    }

    @GetMapping("api/blogs/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Long id){
        Blog blog = blogService.finById(id);

        if(blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }

    @PostMapping("api/blogs")
    public ResponseEntity<Blog> createBlog(@RequestBody BlogCategory blogCategory) {
        Category category = categoryService.findById(blogCategory.getCategory());

        Blog blog1 = new Blog();

        blog1.setTitle(blogCategory.getTitle());
        blog1.setAuthor(blogCategory.getAuthor());
        blog1.setContent(blogCategory.getContent());
        blog1.setCategory(category);

        blogService.save(blog1);

        return new ResponseEntity<Blog>(blog1,HttpStatus.CREATED);
    }

    @PutMapping("api/blogs/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Long id,@RequestBody Blog blog){
        Blog blog1 = blogService.finById(id);

        if(blog1 == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blog1.setTitle(blog.getTitle());
        blog1.setContent(blog.getContent());
        blog1.setAuthor(blog.getAuthor());

        blogService.save(blog1);

        return new ResponseEntity<Blog>(blog1,HttpStatus.OK);

    }

    @DeleteMapping("api/blogs/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id) {
        Blog blog = blogService.finById(id);
        if(blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);

        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }



}