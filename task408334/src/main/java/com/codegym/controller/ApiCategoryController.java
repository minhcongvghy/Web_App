package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiCategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping("api/categories")
    public ResponseEntity<List<Category>> listAllCategory(){
        List<Category> categories = (List<Category>) categoryService.findAll();

        if(categories.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
    }

    @GetMapping("api/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);

        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("api/categories/{id}/blogs")
    public ResponseEntity<List<Blog>> getCategoryBlog(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);

        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<Blog> blogs = (List<Blog>) blogService.findAllByCategory(category);

        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }

    @PostMapping("/api/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category category1 = categoryService.save(category);

        return new ResponseEntity<Category>(category1,HttpStatus.OK);

    }

    @PutMapping("/api/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable ("id") Long id,@RequestBody Category category) {
        Category  category1 = categoryService.findById(id);

        if(category1 == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        category1.setName(category.getName());

        return new ResponseEntity<Category>(category1,HttpStatus.OK);
    }

    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable ("id") Long id){
        Category category = categoryService.findById(id);

        if(category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        categoryService.remove(id);

        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}