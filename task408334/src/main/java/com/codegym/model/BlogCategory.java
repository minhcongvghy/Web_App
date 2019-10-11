package com.codegym.model;

public class BlogCategory {
    private Long id;

    private String title,content,author;

    private Long category;

    public BlogCategory() {
    }

    public BlogCategory(Long id, String title, String content, String author, Long category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}