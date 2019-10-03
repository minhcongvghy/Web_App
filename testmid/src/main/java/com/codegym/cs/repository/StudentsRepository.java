package com.codegym.cs.repository;

import com.codegym.cs.model.Students;
import com.codegym.cs.model.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentsRepository extends PagingAndSortingRepository<Students, Long> {
    Iterable<Students> findAllByClasses(Classes classes);

    Page<Students> findAllByNameContaining(String name, Pageable pageable);
}
