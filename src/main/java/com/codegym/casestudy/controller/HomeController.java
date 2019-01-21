package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Note;
import com.codegym.casestudy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public ModelAndView list(Pageable pageable) {
        Page<Note> note = noteService.findAll(new PageRequest(pageable.getPageNumber(), 5));
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("note", note);
        return modelAndView;
    }
}
