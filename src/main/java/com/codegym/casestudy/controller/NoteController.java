package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.model.Type;
import com.codegym.casestudy.service.NoteService;

import com.codegym.casestudy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private TypeService typeService;

    @ModelAttribute("type")
    private Iterable<Type> type() {
        return typeService.findAll();}

    @GetMapping("/edit-note/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Note note = noteService.findById(id);
        if (note != null) {
            ModelAndView modelAndView = new ModelAndView("/views/edit");
            modelAndView.addObject("note", note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public ModelAndView updateModel(@ModelAttribute("note") Note note) {
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("note", note);
        modelAndView.addObject("message", "Update successful");
        return modelAndView;
    }


    @GetMapping("/create-note")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/views/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView createNote(@Validated @ModelAttribute("note") Note note, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/views/create");
        if (!bindingResult.hasFieldErrors()) {
            noteService.save(note);
            modelAndView.addObject("note", new Note());
            modelAndView.addObject("message", "Create successful");
            return modelAndView;
        }else {
            return modelAndView;
        }
    }
    @GetMapping("/delete-note/{id}")
    public ModelAndView details(@PathVariable Integer id) {
        Note note = noteService.findById(id);
        if (note != null) {
            ModelAndView modelAndView = new ModelAndView("/views/delete");
            modelAndView.addObject("note", note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-note/{id}")
    public String delete(@PathVariable Integer id) {
        Note note = noteService.findById(id);
        ModelAndView modelAndView;
        if (note != null) {
            noteService.remove(note.getId());
            return "redirect:/";
        } else {
            return "redirect:/error404";
        }
    }

    @GetMapping("/error404")
    public String error404() {
        return "error.404";
    }
}
