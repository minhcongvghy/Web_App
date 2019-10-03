package com.codegym.cs.service.impl;

import com.codegym.cs.model.Students;
import com.codegym.cs.model.Classes;
import com.codegym.cs.repository.StudentsRepository;
import com.codegym.cs.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public Page<Students> findAll(Pageable pageable) {
        return studentsRepository.findAll(pageable);
    }

    @Override
    public Students findById(Long id) {
        return studentsRepository.findOne(id);
    }

    @Override
    public void save(Students students) {
        studentsRepository.save(students);
    }

    @Override
    public void remove(Long id) {
        studentsRepository.delete(id);
    }

    @Override
    public Iterable<Students> findAllByClasses(Classes classes) {
        return studentsRepository.findAllByClasses(classes);
    }

    @Override
    public Page<Students> findAllByNameContaining(String name, Pageable pageable) {
        return studentsRepository.findAllByNameContaining(name, pageable);
    }
}
