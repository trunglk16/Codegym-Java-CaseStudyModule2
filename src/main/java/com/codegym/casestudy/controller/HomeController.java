package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public ModelAndView list(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Note> note ;
        if (s.isPresent()) {
            note = noteService.findAllByTitleContainingOrContentContaining(s.get(),s.get(), pageable);
        }else {
            note = printPage(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/views/index");

        modelAndView.addObject("note", note);
        return modelAndView;
    }

    private Page<Note> printPage(Pageable pageable) {
        return noteService.findAll(new PageRequest(pageable.getPageNumber(), 5));
    }
}
