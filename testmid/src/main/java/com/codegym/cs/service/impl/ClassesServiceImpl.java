package com.codegym.cs.service.impl;

import com.codegym.cs.model.Classes;
import com.codegym.cs.repository.ClassesRepository;
import com.codegym.cs.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classes findById(Long id) {
        return classesRepository.findOne(id);
    }

    @Override
    public void save(Classes classes) {
        classesRepository.save(classes);
    }

    @Override
    public void remove(Long id) {
        classesRepository.delete(id);
    }
}

