package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public ModelAndView list(Pageable pageable) {
        Page<Note> note = noteService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView details(@PathVariable int id) {
        Optional<Note> note = noteService.findById(id);
        if (note != null) {
            ModelAndView modelAndView = new ModelAndView("/views/view");
            modelAndView.addObject("note", note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
