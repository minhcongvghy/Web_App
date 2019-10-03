package com.codegym.cs.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String birthdate;
    private String address;
    private String avatar;
    @ManyToOne
    @JoinColumn(name = "classes_id")
    private Classes classes;

    public Students() {
    }

    public Students(String name, String birthdate, String address, String avatar) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.avatar = avatar;
    }
    @Override
    public String toString() {
        return String.format("Students[id=%d, name='%s', birthdate='%s', address='%s', avatar='%s']", id, name, birthdate, address, avatar);
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
