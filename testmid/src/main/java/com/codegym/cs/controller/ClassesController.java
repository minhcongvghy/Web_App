package com.codegym.cs.controller;

import com.codegym.cs.model.Students;
import com.codegym.cs.model.Classes;
import com.codegym.cs.repository.StudentsRepository;
import com.codegym.cs.service.StudentsService;
import com.codegym.cs.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/classes")
    public ModelAndView listClasses(){
        Iterable<Classes> classes = classesService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classes/list");
        modelAndView.addObject("classes", classes);
        return modelAndView;
    }

    @GetMapping("/create-classes")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/classes/create");
        modelAndView.addObject("classes", new Classes());
        return modelAndView;
    }

    @PostMapping("/create-classes")
    public ModelAndView saveClasses(@ModelAttribute("classes") Classes classes){
        classesService.save(classes);

        ModelAndView modelAndView = new ModelAndView("/classes/create");
        modelAndView.addObject("classes", new Classes());
        modelAndView.addObject("message", "New classes created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-classes/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Classes classes = classesService.findById(id);
        if(classes != null) {
            ModelAndView modelAndView = new ModelAndView("/classes/edit");
            modelAndView.addObject("classes", classes);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-classes")
    public ModelAndView updateClasses(@ModelAttribute("classes") Classes classes){
        classesService.save(classes);
        ModelAndView modelAndView = new ModelAndView("/classes/edit");
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("message", "Classes updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-classes/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Classes classes = classesService.findById(id);
        if(classes != null) {
            ModelAndView modelAndView = new ModelAndView("/classes/delete");
            modelAndView.addObject("classes", classes);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-classes")
    public String deleteClasses(@ModelAttribute("classes") Classes classes){
        classesService.remove(classes.getId());
        return "redirect:classes";
    }

    @GetMapping("/view-classes/{id}")
    public ModelAndView viewClasses(@PathVariable("id") Long id){
        Classes classes = classesService.findById(id);
        if(classes == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Students> students = studentsService.findAllByClasses(classes);

        ModelAndView modelAndView = new ModelAndView("/classes/view");
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}
