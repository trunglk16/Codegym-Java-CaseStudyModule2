package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.service.NoteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView details(@PathVariable Integer id) {
        Note note = noteService.findById(id);
        if (note != null) {
            ModelAndView modelAndView = new ModelAndView("/views/view");
            modelAndView.addObject("note", note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
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

    @PostMapping("/edit")
    public ModelAndView updateModel(@ModelAttribute("note") Note note) {
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/views/edit");
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
    public ModelAndView createNote(@ModelAttribute("note") Note note) {
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/views/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("message", "Create successful");
        return modelAndView;
    }

    @GetMapping("/delete-note/{id}")
    public String delete(@PathVariable Integer id) {
        Note note = noteService.findById(id);
        if (note != null) {
            noteService.remove(note.getId());
            return "redirect:/";
        }else {
            return "redirect:/error.404";
        }
    }
}
