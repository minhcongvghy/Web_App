package com.codegym.cs.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "classes")
    private Set<Students> students;

    public Classes() {
    }

    public Classes(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}

