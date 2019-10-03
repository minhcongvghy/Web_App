package com.codegym.cs.controller;

import com.codegym.cs.model.Students;
import com.codegym.cs.model.Classes;
import com.codegym.cs.service.StudentsService;
import com.codegym.cs.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private ClassesService classesService;

    @ModelAttribute("classes")
    public Iterable<Classes> classes(){
        return classesService.findAll();
    }

    @GetMapping("/students")
    public ModelAndView listStudents(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Students> students;
        if(s.isPresent()){
            students = studentsService.findAllByNameContaining(s.get(), pageable);
        } else {
            students = studentsService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/students/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create-students")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/students/create");
        modelAndView.addObject("students", new Students());
        return modelAndView;
    }

    @PostMapping("/create-students")
    public ModelAndView saveCustomer(@ModelAttribute("students") Students students){
        studentsService.save(students);
        ModelAndView modelAndView = new ModelAndView("/students/create");
        modelAndView.addObject("students", new Students());
        modelAndView.addObject("message", "New students created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-students/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Students students = studentsService.findById(id);
        if(students != null) {
            ModelAndView modelAndView = new ModelAndView("/students/edit");
            modelAndView.addObject("students", students);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-students")
    public ModelAndView updateStudents(@ModelAttribute("students") Students students){
        studentsService.save(students);
        ModelAndView modelAndView = new ModelAndView("/students/edit");
        modelAndView.addObject("students", students);
        modelAndView.addObject("message", "Students updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-students/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Students students = studentsService.findById(id);
        if(students != null) {
            ModelAndView modelAndView = new ModelAndView("/students/delete");
            modelAndView.addObject("students", students);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-students")
    public String deleteCustomer(@ModelAttribute("students") Students students){
        studentsService.remove(students.getId());
        return "redirect:students";
    }
}

