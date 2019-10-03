package com.codegym.cs.service;

import com.codegym.cs.model.Classes;

public interface ClassesService {
    Iterable<Classes> findAll();

    Classes findById(Long id);

    void save(Classes classes);

    void remove(Long id);
}

