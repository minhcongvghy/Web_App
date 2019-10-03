package com.codegym.cs.service;

import com.codegym.cs.model.Students;
import com.codegym.cs.model.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentsService {
    Page<Students> findAll(Pageable pageable);

    Students findById(Long id);

    void save(Students students);

    void remove(Long id);

    Iterable<Students> findAllByClasses(Classes classes);

    Page<Students> findAllByNameContaining(String name, Pageable pageable);
}
